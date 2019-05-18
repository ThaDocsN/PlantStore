package com.thadocizn.plantstore.models

import androidx.lifecycle.LiveData

class CategoryRepository(val dao: CategoryDAO) {

    val categories: LiveData<List<Category>> = dao.getAllCategories()

    fun inserCategory(category: Category) = dao.insert(category)

    fun updateCategory(category: Category) = dao.update(category)

    fun deleteCategory(category: Category) = dao.update(category)
}