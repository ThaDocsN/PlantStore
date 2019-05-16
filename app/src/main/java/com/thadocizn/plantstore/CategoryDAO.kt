package com.thadocizn.plantstore

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.thadocizn.plantstore.models.Category


/**
 * Created by charles on 16,May,2019
 */
@Dao
interface CategoryDAO {
    @Insert
    fun insert(category: Category)

    @Update
    fun update(category: Category)

    @Delete
    fun delete(category: Category)

    @Query("SELECT * FROM categories_table")
    fun getAllCategories(): LiveData<List<Category>>

}