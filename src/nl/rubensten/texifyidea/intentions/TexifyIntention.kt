package nl.rubensten.texifyidea.intentions

import com.intellij.codeInsight.intention.IntentionAction

/**
 * Base class for TeXiFy intentions.
 *
 * @author Sten Wessel
 */
abstract class TexifyIntention : IntentionAction {

    override fun startInWriteAction() = true
}
