package uz.mahmudxon.ru_uzdictionary.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.mahmudxon.ru_uzdictionary.db.dao.Dao
import uz.mahmudxon.ru_uzdictionary.model.Word

@Database(entities = [Word::class], version = 1)
abstract class RuDB : RoomDatabase()
{
    abstract fun dao() : Dao

    companion object {


        private var instance: RuDB? = null

        fun initDatabase(context: Context) {
            synchronized(this) {
                if (instance == null) {
                    instance = Room
                        .databaseBuilder(context.applicationContext, RuDB::class.java, "ru.db")
                        .fallbackToDestructiveMigration()
                        .createFromAsset("ru.db")
                        .build()
                }
            }
        }

        fun getDatabase() = instance!!

        }



    }