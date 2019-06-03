package com.example.basketdex

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.basketdex.Database.PartidoDAO
import com.example.basketdex.Database.Partido

@Database(entities = [Partido:: class], version = 1, exportSchema = false)
public abstract class RoomDB : RoomDatabase(){
    abstract fun partidoDao() : PartidoDAO

    companion object{
        private var INSTANCE: RoomDB? = null

        fun getInstance(Appcontext: Context): RoomDB{
            val tempInstance = INSTANCE
            if(tempInstance != null) return tempInstance
            synchronized(this){
                val instance = Room
                    .databaseBuilder(Appcontext, RoomDB::class.java, "PartidoDB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}