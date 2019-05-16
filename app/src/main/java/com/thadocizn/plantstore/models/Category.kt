package com.thadocizn.plantstore.models

import androidx.room.Entity
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

/**
 * Created by charles on 15,May,2019
 */
@Entity(tableName = "categories_table")
data class Category(var catId: Int, var catName: String, var catDescription: String) : BaseObservable() {

    @get:Bindable
    var id: Int = catId
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.id)
            }

        }
    @get:Bindable
    var name: String = catName
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.name)
            }

        }

    @get:Bindable
    var description: String = catDescription
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.description)
            }

        }
}