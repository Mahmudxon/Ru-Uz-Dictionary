package uz.mahmudxon.ru_uzdictionary.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WORDS")
data class Word(
    @PrimaryKey
    val id: Int,
    val word: String?,
    val meaning: String?,
    @ColumnInfo(defaultValue = "0")
    var isfav: Int?

) {
    constructor() : this(0, "", "", 0)
}