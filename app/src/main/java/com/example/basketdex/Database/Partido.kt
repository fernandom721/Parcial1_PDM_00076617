package com.example.basketdex.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.time.LocalTime


@Entity (tableName = "partidos")
data class Partido(

    @ColumnInfo(name = "teamA")
    val teamA: String,
    @ColumnInfo(name = "scoreA")
    val scoreA: Int,
    @ColumnInfo(name = "teamB")
    val teamB: String,
    @ColumnInfo(name = "scoreB")
    val scoreB: Int,
    @ColumnInfo(name = "fecha")
    val fecha: String,
    @ColumnInfo(name = "hora")
    val hora: String
){
    @PrimaryKey(autoGenerate = true)
    var idPartido: Long = 0
}