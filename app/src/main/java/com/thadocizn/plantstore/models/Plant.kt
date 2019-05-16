package com.thadocizn.plantstore.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.databinding.BaseObservable

/**
 * Created by charles on 15,May,2019
 */

@Entity(tableName = "books_table")
class Plant:BaseObservable() {
}