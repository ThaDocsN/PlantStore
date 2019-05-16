package com.thadocizn.plantstore

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.thadocizn.plantstore.models.Category
import com.thadocizn.plantstore.models.Plant


/**
 * Created by charles on 16,May,2019
 */
class PlantRepository {

    private lateinit var categoryDAO: CategoryDAO
    private lateinit var plantDAO: PlantDAO
    private val categories: LiveData<List<Category>>? = null
    private val plants: LiveData<List<Plant>>? = null

    fun PlantRepository(application: Application) {

        val plantDatabase = PlantDatabase.getInstance(application)
        categoryDAO = plantDatabase.categoryDAO()
        plantDAO = plantDatabase.plantDAO()
    }

    fun getCategories(): LiveData<List<Category>> {
        return categoryDAO.getAllCategories()
    }

    fun getPlants(categoryId: Int): LiveData<List<Plant>> {
        return plantDAO.getPlants(categoryId)
    }

    fun insertCategory(category: Category) {

        InsertCategoryAsyncTask(categoryDAO).execute(category)
    }

    private class InsertCategoryAsyncTask(private val categoryDAO: CategoryDAO) : AsyncTask<Category, Void, Void>() {

        override fun doInBackground(vararg categories: Category): Void? {

            categoryDAO.insert(categories[0])
            return null
        }
    }

    fun insertPlant(plant: Plant) {

        InsertPlantAsyncTask(plantDAO).execute(plant)
    }

    private class InsertPlantAsyncTask(private val plantDAO: PlantDAO) : AsyncTask<Plant, Void, Void>() {

        override fun doInBackground(vararg plants: Plant): Void? {

            plantDAO.insert(plants[0])
            return null
        }
    }

    fun deleteCategory(category: Category) {

        DeleteCategoryAsyncTask(categoryDAO).execute(category)
    }

    private class DeleteCategoryAsyncTask(private val categoryDAO: CategoryDAO) : AsyncTask<Category, Void, Void>() {

        override fun doInBackground(vararg categories: Category): Void? {

            categoryDAO.delete(categories[0])
            return null
        }
    }

    fun deletePlant(plant: Plant) {

        DeletePlantAsyncTask(plantDAO).execute(plant)
    }

    private class DeletePlantAsyncTask(private val plantDAO: PlantDAO) : AsyncTask<Plant, Void, Void>() {

        override fun doInBackground(vararg plants: Plant): Void? {

            plantDAO.delete(plants[0])
            return null
        }
    }

    fun updateCategory(category: Category) {

        UpdateCategoryAsyncTask(categoryDAO).execute(category)
    }

    private class UpdateCategoryAsyncTask(private val categoryDAO: CategoryDAO) : AsyncTask<Category, Void, Void>() {

        override fun doInBackground(vararg categories: Category): Void? {

            categoryDAO.update(categories[0])
            return null
        }
    }

    fun updatePlant(plant: Plant) {

        UpdatePlantAsyncTask(plantDAO).execute(plant)
    }

    private class UpdatePlantAsyncTask(private val plantDAO: PlantDAO) : AsyncTask<Plant, Void, Void>() {

        override fun doInBackground(vararg plants: Plant): Void? {

            plantDAO.update(plants[0])
            return null
        }
    }

}