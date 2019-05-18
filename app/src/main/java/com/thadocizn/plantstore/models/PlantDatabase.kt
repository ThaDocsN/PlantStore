package com.thadocizn.plantstore.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * Created by charles on 16,May,2019
 */
@Database(entities = [Category::class, Plant::class], version = 1)
abstract class PlantDatabase : RoomDatabase() {

    abstract fun categoryDAO(): CategoryDAO
    abstract fun plantDAO(): PlantDAO

    companion object {

        @Volatile
        private var Instance: PlantDatabase? = null

        fun getInstance(context: Context, scope: CoroutineScope): PlantDatabase {

            return Instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlantDatabase::class.java,
                    "plant_database"
                )
                    .fallbackToDestructiveMigrationFrom()
                    .addCallback(PlantDatabaseCallback(scope))
                    .build()
                Instance = instance
                instance
            }

        }
        private class PlantDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
// If you want to keep the data through app restarts,
                // comment out the following line.
                Instance?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.plantDAO(), database.categoryDAO())
                    }
                }
            }
        }

        fun populateDatabase(plantDAO: PlantDAO, categoryDAO: CategoryDAO) {

            var category = Category(1, "Home","Tesst")
            categoryDAO.insert(category)
            category = Category(2, "Outdoor", "Garden")
            categoryDAO.insert(category)

            var plant = Plant(1,"Charles", 1)
            plantDAO.insert(plant)
            plant = Plant(2, "Heather", 2)
            plantDAO.insert(plant)
        }
    }
}
