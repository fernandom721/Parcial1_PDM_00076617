package com.example.basketdex.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.basketdex.Database.PartidoDAO
import com.example.basketdex.Database.Partido

class PartidoRepository (private val partidoDao: PartidoDAO){

    @WorkerThread
    suspend fun insert(repo: Partido){
        partidoDao.insert(repo)
    }

    fun getAll(): LiveData<List<Partido>> = partidoDao.getAllPartidos()

    fun delete() = partidoDao.deleteTable()
}