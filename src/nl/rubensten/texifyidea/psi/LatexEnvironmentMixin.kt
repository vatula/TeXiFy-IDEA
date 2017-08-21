package nl.rubensten.texifyidea.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiLanguageInjectionHost

/**
 *
 * @author Sten Wessel
 */
abstract class LatexEnvironmentMixin(node: ASTNode) : ASTWrapperPsiElement(node), LatexEnvironment, PsiLanguageInjectionHost {

    override fun isValidHost() = true

    override fun updateText(text: String): PsiLanguageInjectionHost {
        return this
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost> {
        return LiteralTextEscaper.createSimple(this)
    }
}
