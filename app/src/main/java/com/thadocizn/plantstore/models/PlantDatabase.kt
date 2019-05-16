package com.thadocizn.plantstore.models

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context


/**
 * Created by charles on 16,May,2019
 */
@Database(entities = [Category::class, Plant::class], version = 1)
abstract class PlantDatabase : RoomDatabase() {

    abstract fun categoryDAO(): CategoryDAO
    abstract fun plantDAO(): PlantDAO
    companion object{

        @Volatile
        private var instance: PlantDatabase? = null
        fun getInstance(context: Context): PlantDatabase {
            if (instance == null) {
                @Synchronized
                instance = Room.databaseBuilder(
                    context,
                    PlantDatabase::class.java, "plant_database")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance as PlantDatabase
        }

    }
}