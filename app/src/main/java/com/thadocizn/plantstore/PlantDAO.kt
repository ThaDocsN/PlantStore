package com.thadocizn.plantstore

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.thadocizn.plantstore.models.Plant


/**
 * Created by charles on 16,May,2019
 */
@Dao
interface PlantDAO {
    @Insert
    fun insert(plant: Plant)

    @Update
    fun update(plant: Plant)

    @Delete
    fun delete(plant: Plant)

    @Query("SELECT * FROM plants_table")
    fun getAllBooks(): LiveData<List<Plant>>

    @Query("SELECT * FROM plants_table WHERE plant_category==:categoryId")
    fun getBooks(categoryId: Int): LiveData<List<Plant>>

}