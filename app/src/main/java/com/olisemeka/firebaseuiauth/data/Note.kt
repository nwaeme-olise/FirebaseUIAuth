package com.olisemeka.firebaseuiauth.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Note(
    @PrimaryKey
    var id: String,
    var title: String,
    var body: String,
    var date: Long,
    var announcement: Boolean
)