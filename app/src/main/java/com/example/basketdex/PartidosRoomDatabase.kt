package com.example.basketdex

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.basketdex.Database.PartidoDAO
import com.example.basketdex.Database.Partido
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Partido::class],version = 1,exportSchema = false)
public abstract class PartidosRoomDatabase : RoomDatabase(){

    abstract fun partidoDAO():PartidoDAO

    companion object {
        @Volatile
        private var INSTANCE: PartidosRoomDatabase? = null

        fun getInstance(AppContext: Context): PartidosRoomDatabase{
            val temp = INSTANCE

            if(temp != null){
                return temp
            }

            synchronized(this){
                val instance = Room.databaseBuilder(AppContext, PartidosRoomDatabase::class.java, "PartidosDB")
                    .build()

                INSTANCE = instance
                return instance
            }
        }

        private class PartidosDataBaseCallBack(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback(){

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.partidoDAO())
                    }
                }
            }
        }

        suspend fun populateDatabase(partidoDAO: PartidoDAO){

            partidoDAO.deleteTable()

            var partidos = Partido("Crustaceo Cascarudo", 100,
                "Balde de Carnada", 75,
                "09/11/20001","12:00:00")
            partidoDAO.insert(partidos)
        }
    }
}