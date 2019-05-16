package com.thadocizn.plantstore

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.os.AsyncTask
import com.thadocizn.plantstore.models.Category
import com.thadocizn.plantstore.models.Plant


/**
 * Created by charles on 16,May,2019
 */

abstract class PlantDatabase : RoomDatabase() {

    abstract fun categoryDAO(): CategoryDAO
    abstract fun plantDAO(): PlantDAO

    private var instance: PlantDatabase? = null

    @Synchronized
    fun getInstance(context: Context): PlantDatabase {
        if (instance == null) {
            instance = Room.databaseBuilder(
                context,
                PlantDatabase::class.java, "plant_database")
                .fallbackToDestructiveMigration()
                .addCallback(callback)
                .build()
        }
        return instance as PlantDatabase
    }


    private val callback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            InitialDataAsyncTask(instance!!).execute()
        }
    }

    private class InitialDataAsyncTask(PlantDatabase: PlantDatabase) : AsyncTask<Void, Void, Void>() {
        private val categoryDAO: CategoryDAO = PlantDatabase.categoryDAO()
        private val plantDAO: PlantDAO = PlantDatabase.plantDAO()

        override fun doInBackground(vararg voids: Void): Void? {

            val category1 = Category(1, "House", "fjsjhfskj")
            val category2 = Category(2, "Exotic", "fjsjhfskj")
            val category3 = Category(3, "Desert", "fjsjhfskj")


            categoryDAO.insert(category1)
            categoryDAO.insert(category2)
            categoryDAO.insert(category3)

            val plant1  = Plant(1, "Plant", 2)
            val plant2  = Plant(2, "Plant", 2)
            val plant3  = Plant(3, "Plant", 2)
            val plant4  = Plant(4, "Plant", 1)
            val plant5  = Plant(5, "Plant", 3)
            val plant6  = Plant(6, "Plant", 3)
            val plant7  = Plant(7, "Plant", 1)
            val plant8  = Plant(8, "Plant", 3)
            val plant9  = Plant(9, "Plant", 1)
            val plant10 = Plant(10, "Plant", 2)
            val plant11 = Plant(11, "Plant", 3)

            plantDAO.insert(plant1)
            plantDAO.insert(plant2)
            plantDAO.insert(plant3)
            plantDAO.insert(plant4)
            plantDAO.insert(plant5)
            plantDAO.insert(plant6)
            plantDAO.insert(plant7)
            plantDAO.insert(plant8)
            plantDAO.insert(plant9)
            plantDAO.insert(plant10)
            plantDAO.insert(plant11)

                return null
        }
    }

}