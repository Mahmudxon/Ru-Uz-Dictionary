package uz.mahmudxon.ru_uzdictionary.util

import android.annotation.SuppressLint
import android.content.Context

object Prefs {

    object Language
    {
        val RU = "Ruscha - O'zbekcha"
        val UZ = "O'zbekcha - Ruscha"
    }

    @SuppressLint("ApplySharedPref")
    fun saveLang(context: Context, language : String)
    {
        context.getSharedPreferences("app", Context.MODE_PRIVATE).edit().putString("language", language).apply()
    }

    fun getLanguage(context: Context) : String? =
        context.getSharedPreferences("app", Context.MODE_PRIVATE).getString("language", Language.RU)
}