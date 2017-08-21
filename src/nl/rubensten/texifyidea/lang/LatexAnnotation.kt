package nl.rubensten.texifyidea.lang

/**
 *
 * @author Sten Wessel
 */
data class LatexAnnotation(val key: String, val value: String? = null) {
    companion object {
        @JvmStatic val KEY_INJECT_LANGUAGE = "InjectLanguage"
    }

    override fun toString()= "% !TeX $key ${if (value != null) "= $value" else ""}"

}
