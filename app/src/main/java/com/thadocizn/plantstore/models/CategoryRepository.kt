package com.thadocizn.plantstore.models

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class CategoryRepository(val dao: CategoryDAO) {

    val categories: LiveData<List<Category>> = dao.getAllCategories()

    @WorkerThread
    fun inserCategory(category: Category) = dao.insert(category)

    @WorkerThread
    fun updateCategory(category: Category) = dao.update(category)

    @WorkerThread
    fun deleteCategory(category: Category) = dao.update(category)
}