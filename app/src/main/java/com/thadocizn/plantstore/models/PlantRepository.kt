package com.thadocizn.plantstore.models

import androidx.lifecycle.LiveData
import androidx.annotation.WorkerThread
import com.thadocizn.plantstore.models.Category
import com.thadocizn.plantstore.models.CategoryDAO
import com.thadocizn.plantstore.models.Plant
import com.thadocizn.plantstore.models.PlantDAO


/**
 * Created by charles on 16,May,2019
 */
class PlantRepository(private val plantDAO: PlantDAO) {

    val plants: LiveData<List<Plant>> = plantDAO.getAllPlants()


    @WorkerThread
    suspend fun insertPlant(plant: Plant) {

        plantDAO.insert(plant)
    }

    @WorkerThread
    fun deletePlant(plant: Plant) {

        plantDAO.delete(plant)
    }

    @WorkerThread
    fun updatePlant(plant: Plant) {

        plantDAO.update(plant)
    }

}