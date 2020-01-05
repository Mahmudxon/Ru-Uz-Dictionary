package uz.mahmudxon.ru_uzdictionary.repository

import android.content.Context
import uz.mahmudxon.ru_uzdictionary.db.database.RuDB
import uz.mahmudxon.ru_uzdictionary.db.database.UzDB
import uz.mahmudxon.ru_uzdictionary.model.Word

class Repository private constructor(context: Context) {
    private lateinit var ruDB: RuDB
    private lateinit var uzDB: UzDB

    init {
        UzDB.initDatabase(context)
        RuDB.initDatabase(context)
        uzDB = UzDB.getDatabase()
        ruDB = RuDB.getDatabase()
    }

    companion object {
        private var instens: Repository? = null
        fun getInstens(context: Context): Repository {
            if (instens == null)
                instens = Repository(context)
            return instens!!
        }
    }

    fun getRuWORDS() = ruDB.dao().getAllWords()
    fun getUzWORDS() = uzDB.dao().getAllWords()
    fun getRuFavWORDS() = ruDB.dao().getFavorautes()
    fun getUzFavWORDS() = uzDB.dao().getFavorautes()
    fun updateRuWord(word: Word) = ruDB.dao().updateWord(word)
    fun updateUzWord(word: Word) = uzDB.dao().updateWord(word)
//    fun searchRuWord(s: String) = ruDB.dao().search(s)
//    fun searchUzWord(s: String) = uzDB.dao().search(s)
}