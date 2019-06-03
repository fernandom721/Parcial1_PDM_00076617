package com.example.basketdex.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.basketdex.Database.Partido
import com.example.basketdex.PartidosRoomDatabase
import com.example.basketdex.Repository.PartidoRepository
import com.example.basketdex.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartidoViewModel (app: Application): AndroidViewModel(app){
    private val repository: PartidoRepository

    init{
        //loadPartido()
        val partidoDao=RoomDB.getInstance(app).partidoDao()
        repository= PartidoRepository(partidoDao)
    }

    fun insertPartido(partido: Partido)=viewModelScope.launch(Dispatchers.IO) {
        repository.insert(partido)
    }

    fun getAllPartido(): LiveData<List<Partido>> = repository!!.getAll()

    private fun loadPartido(){
        val daoPartido = PartidosRoomDatabase.getInstance(getApplication())
    }

}