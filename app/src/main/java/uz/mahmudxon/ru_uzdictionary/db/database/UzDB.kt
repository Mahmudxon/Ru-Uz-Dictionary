package uz.mahmudxon.ru_uzdictionary.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.mahmudxon.ru_uzdictionary.db.dao.Dao
import uz.mahmudxon.ru_uzdictionary.model.Word

@Database(entities = [Word::class], version = 1)
abstract class UzDB : RoomDatabase()
{
    abstract fun dao() : Dao

    companion object {

        private var instance: UzDB? = null

        fun initDatabase(context: Context) {
            synchronized(this) {
                if (instance == null) {
                    instance = Room
                        .databaseBuilder(context.applicationContext, UzDB::class.java, "uz.db")
                        .fallbackToDestructiveMigration()
                        .createFromAsset("uz.db")
                        .build()
                }
            }
        }

        fun getDatabase() = instance!!

    }
}