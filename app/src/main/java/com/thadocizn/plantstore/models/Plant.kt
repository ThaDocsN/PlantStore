package com.thadocizn.plantstore.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.PrimaryKey
import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR

/**
 * Created by charles on 15,May,2019
 */

@Entity(
    tableName = "plants_table",
    foreignKeys = [ForeignKey(
        entity = Category::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("category_id"),
        onDelete = CASCADE
    )]
)
data class Plant(var plantId: Int, var plantName: String, var categoryId: Int) : BaseObservable() {

    @PrimaryKey(autoGenerate = true)
    @get:Bindable
    var plant_id: Int = plantId
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.plant_id)
            }
        }

    @get:Bindable
    var plant_name: String = plantName
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.plant_name)
            }
        }

    @get:Bindable
    var plant_category: Int = categoryId
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.plant_category)
            }
        }

}