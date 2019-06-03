package com.example.basketdex.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface PartidoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo: Partido)

    @Query("SELECT * FROM partidos")
    fun getAllPartidos(): LiveData<List<Partido>>

    @Query("DELETE FROM partidos")
    fun deleteTable()
}