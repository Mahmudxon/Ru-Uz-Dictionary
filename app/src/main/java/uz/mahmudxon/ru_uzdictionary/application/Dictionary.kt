package uz.mahmudxon.ru_uzdictionary.application

import android.annotation.SuppressLint
import android.app.Application
import java.io.File

class Dictionary : Application() {
    @SuppressLint("SdCardPath")
    override fun onCreate() {
        super.onCreate()
//        val file = File("/data/data/$packageName/databases/UZBRUS_WORDS_DB.db")
//        if (!file.exists()) {
//            copyBaseFromAssets()
//        }
    }

//    @SuppressLint("SdCardPath")
//    private fun copyBaseFromAssets() {
//        val uzDBA = assets.open("uz.db")
//        val uzDB = File("/data/data/$packageName/databases/UZBRUS_WORDS_DB.db")
//        uzDB.mkdirs()
//        uzDBA.copyTo(uzDB.outputStream(), 1024)
//
//        val ruDBA = assets.open("ru.db")
//        val ruDB = File("/data/data/$packageName/databases/RUSUZB_WORDS_DB.db")
//        ruDBA.copyTo(out = ruDB.outputStream(), bufferSize = 1024)
//    }
}