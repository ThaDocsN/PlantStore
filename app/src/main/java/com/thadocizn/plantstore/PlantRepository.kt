package com.thadocizn.plantstore

import androidx.lifecycle.LiveData
import androidx.annotation.WorkerThread
import com.thadocizn.plantstore.models.Category
import com.thadocizn.plantstore.models.Plant


/**
 * Created by charles on 16,May,2019
 */
class PlantRepository(private val categoryDAO: CategoryDAO, private val plantDAO: PlantDAO) {

    val categories: LiveData<List<Category>> = categoryDAO.getAllCategories()
    val plants: LiveData<List<Plant>> = plantDAO.getAllPlants()

    @WorkerThread
    suspend fun insertCategory(category: Category) {

        categoryDAO.insert(category)
    }

    @WorkerThread
    suspend fun insertPlant(plant: Plant) {

        plantDAO.insert(plant)
    }

    @WorkerThread
    fun deleteCategory(category: Category) {

        categoryDAO.delete(category)
    }

    @WorkerThread
    fun deletePlant(plant: Plant) {

        plantDAO.delete(plant)
    }

    @WorkerThread
    fun updateCategory(category: Category) {

        categoryDAO.update(category)
    }

    @WorkerThread
    fun updatePlant(plant: Plant) {

        plantDAO.update(plant)
    }

}