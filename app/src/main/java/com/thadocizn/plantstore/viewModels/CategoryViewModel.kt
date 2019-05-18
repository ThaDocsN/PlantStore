package com.thadocizn.plantstore.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.thadocizn.plantstore.models.Category
import com.thadocizn.plantstore.models.CategoryRepository
import com.thadocizn.plantstore.models.PlantDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

     val repo: CategoryRepository
     val allCategories: LiveData<List<Category>>

    init {
        val dao = PlantDatabase.getInstance(application, GlobalScope).categoryDAO()
        repo = CategoryRepository(dao)
        allCategories = repo.categories
    }

    fun insert(category: Category) = GlobalScope.launch(Dispatchers.IO) {
        repo.inserCategory(category)
    }

    fun update(category: Category) = GlobalScope.launch(Dispatchers.IO) {
        repo.updateCategory(category)
    }

    fun delete(category: Category) = GlobalScope.launch(Dispatchers.IO) {
        repo.deleteCategory(category)
    }
}