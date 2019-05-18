package com.thadocizn.plantstore.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.thadocizn.plantstore.models.Plant
import com.thadocizn.plantstore.models.PlantDatabase
import com.thadocizn.plantstore.models.PlantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Created by charles on 16,May,2019
 */
class PlantViewModel(application: Application) : AndroidViewModel(application) {

    val repo: PlantRepository

    var allPlants: LiveData<List<Plant>>

    init {
        val dao = PlantDatabase.getInstance(application, GlobalScope).plantDAO()
        repo = PlantRepository(dao)
        allPlants = repo.plants
    }

    fun insert(plant: Plant) = GlobalScope.launch(Dispatchers.IO) {
        repo.insertPlant(plant)
    }

    fun update(plant: Plant) = GlobalScope.launch(Dispatchers.IO) {
        repo.updatePlant(plant)
    }

    fun delete(plant: Plant) = GlobalScope.launch(Dispatchers.IO) {
        repo.deletePlant(plant)
    }
}