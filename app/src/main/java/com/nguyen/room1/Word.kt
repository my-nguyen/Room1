package com.nguyen.room1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)