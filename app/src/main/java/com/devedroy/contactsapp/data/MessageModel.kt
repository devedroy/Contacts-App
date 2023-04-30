package com.devedroy.contactsapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "message_db")
data class MessageModel(
    val name: String,
    val otp: Int,
    val time: String,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
) {
    constructor(name: String, otp: Int, time: String) : this(name, otp, time, null)
}
