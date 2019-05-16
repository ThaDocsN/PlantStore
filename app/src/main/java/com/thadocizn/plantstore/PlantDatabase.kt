package com.thadocizn.plantstore

import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import android.os.AsyncTask
import com.thadocizn.plantstore.models.Category
import com.thadocizn.plantstore.models.Plant


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