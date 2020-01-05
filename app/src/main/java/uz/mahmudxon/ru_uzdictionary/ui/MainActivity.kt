package uz.mahmudxon.ru_uzdictionary.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.mahmudxon.ru_uzdictionary.R
import uz.mahmudxon.ru_uzdictionary.ui.main.view.MainFragment
import uz.mahmudxon.ru_uzdictionary.util.log
import uz.mahmudxon.ru_uzdictionary.util.startFragment
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        val file = File("/data/data/$packageName/databases/uz.db")
//        if (!file.exists()) {
//            copyBaseFromAssets()
//        }
        startFragment(MainFragment(), false)
    }

// jin ursin axir roomni tayyor assetdan oladigan funksiyasi bor ekanku :-)
//    @SuppressLint("SdCardPath")
//    private fun copyBaseFromAssets() {
//        log("Fayl mavjud emas!")
//        val dir = File("/data/data/$packageName/databases/")
//        if(!dir.exists()) {
//            dir.mkdirs()
//            log("papka yaratildi!")
//        }
//
//        val uzDBA = assets.open("uz.db")
//        val uzDB = File("/data/data/$packageName/databases/uz.db")
//
//        uzDBA.copyTo(uzDB.outputStream(), 1024)
//
//        val ruDBA = assets.open("ru.db")
//        val ruDB = File("/data/data/$packageName/databases/ru.db")
//        ruDBA.copyTo(out = ruDB.outputStream(), bufferSize = 1024)
//    }
}
