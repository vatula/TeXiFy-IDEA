package nl.rubensten.texifyidea.run

import com.intellij.execution.Location
import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.RunConfigurationProducer
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import nl.rubensten.texifyidea.file.LatexFileType
import nl.rubensten.texifyidea.run.compiler.BibliographyCompiler
import nl.rubensten.texifyidea.util.hasBibliography
import nl.rubensten.texifyidea.util.usesBiber

/**
 * @author Ruben Schellekens
 */
class LatexRunConfigurationProducer : RunConfigurationProducer<LatexRunConfiguration>(LatexRunConfigurationType.instance) {

    override fun setupConfigurationFromContext(runConfiguration: LatexRunConfiguration,
                                               context: ConfigurationContext,
                                               sourceElement: Ref<PsiElement>): Boolean {
        val location = context.location ?: return false
        val container = getEntryPointContainer(location) ?: return false
        val mainFile = container.virtualFile ?: return false

        // Only activate on .tex files.
        val extension = mainFile.extension
        val texTension = LatexFileType.defaultExtension
        if (extension == null || !extension.equals(texTension, ignoreCase = true)) {
            return false
        }

        // Setup run configuration.
        runConfiguration.mainFile = mainFile
        runConfiguration.setDefaultAuxiliaryDirectories()
        runConfiguration.setDefaultCompiler()
        runConfiguration.setDefaultOutputFormat()
        runConfiguration.setSuggestedName()

        if (container.hasBibliography()) {
            runConfiguration.generateBibRunConfig(BibliographyCompiler.BIBTEX)
        }
        else if (container.usesBiber()) {
            runConfiguration.generateBibRunConfig(BibliographyCompiler.BIBER)
        }

        return true
    }

    private fun getEntryPointContainer(location: Location<*>?): PsiFile? {
        if (location == null) {
            return null
        }

        val locationElement = location.psiElement
        return locationElement.containingFile
    }

    override fun isConfigurationFromContext(runConfiguration: LatexRunConfiguration,
                                            context: ConfigurationContext): Boolean {
        val mainFile = runConfiguration.mainFile
        val psiFile = context.dataContext.getData(PlatformDataKeys.PSI_FILE) ?: return false
        val currentFile = psiFile.virtualFile ?: return false
        return mainFile?.path == currentFile.path
    }
}