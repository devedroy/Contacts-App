package com.devedroy.contactsapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MessageModel::class],
    version = 1,
)
abstract class MessageDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
}