package uz.mahmudxon.ru_uzdictionary.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Observable
import uz.mahmudxon.ru_uzdictionary.model.Word

@Dao
interface Dao {

    @Update
    fun updateWord(word: Word) : Completable

    @Query("select id, word, meaning, isfav from WORDS order by lower(word)")
    fun getAllWords(): Observable<List<Word>>

    @Query("select * from WORDS where isfav = 1 order by lower(word)")
    fun getFavorautes(): Observable<List<Word>>

//    @Query("select id, word, meaning, isfav from WORDS where word like :s or word is null")
//    fun search(s : String?)

}