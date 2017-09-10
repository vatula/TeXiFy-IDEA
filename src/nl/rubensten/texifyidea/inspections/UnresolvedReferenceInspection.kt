package nl.rubensten.texifyidea.inspections

import com.intellij.codeInspection.InspectionManager
import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import nl.rubensten.texifyidea.util.TexifyUtil
import nl.rubensten.texifyidea.util.commandsInFileSet
import kotlin.reflect.jvm.internal.impl.utils.SmartList

/**
 * @author Ruben Schellekens
 */
open class UnresolvedReferenceInspection : TexifyInspectionBase() {

    companion object {
        val NO_FIX: LocalQuickFix? = null
    }

    override fun getDisplayName(): String {
        return "Unresolved reference"
    }

    override fun getInspectionId(): String {
        return "UnresolvedReference"
    }

    override fun inspectFile(file: PsiFile, manager: InspectionManager, isOntheFly: Boolean): List<ProblemDescriptor> {
        val descriptors = SmartList<ProblemDescriptor>()

        val labels = TexifyUtil.findLabelsInFileSet(file)
        val commands = file.commandsInFileSet()
        for (cmd in commands) {
            if (!NonBreakingSpaceInspection.REFERENCE_COMMANDS.contains(cmd.name)) {
                continue
            }

            val required = cmd.requiredParameters
            if (required.isEmpty()) {
                continue
            }

            val parts = required[0].split(",")
            for (i in 0 until parts.size) {
                val part = parts[i]
                if (!labels.contains(part)) {
                    var offset = cmd.name!!.length + 1
                    for (j in 0 until i) {
                        offset += parts[j].length + 1
                    }

                    descriptors.add(manager.createProblemDescriptor(
                            cmd,
                            TextRange.from(offset, part.length),
                            "Unresolved reference '$part'",
                            ProblemHighlightType.GENERIC_ERROR_OR_WARNING,
                            isOntheFly
                    ))
                }
            }
        }

        return descriptors
    }
}