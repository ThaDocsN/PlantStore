package com.thadocizn.plantstore.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR

/**
 * Created by charles on 15,May,2019
 */

@Entity(tableName = "plants_table")
data class Plant(var plantId: Int, var plantName: String, var categoryId: Int):BaseObservable() {

    @get:Bindable
    var plId: Int = plantId
    set(value) {
        if (field != value){
            field = value
            notifyPropertyChanged(BR.plId)
        }
    }

    @get:Bindable
    var plName: String = plantName
        set(value) {
            if (field != value){
                field = value
                notifyPropertyChanged(BR.plName)
            }
        }

    @get:Bindable
    var plCategory: Int = categoryId
        set(value) {
            if (field != value){
                field = value
                notifyPropertyChanged(BR.plCategory)
            }
        }

}