package com.devedroy.contactsapp

import android.app.Application
import androidx.room.Room
import com.devedroy.contactsapp.data.MessageDatabase

class App : Application() {
    companion object {
        lateinit var messageDatabase: MessageDatabase
    }

    override fun onCreate() {
        super.onCreate()
        messageDatabase = Room.databaseBuilder(
            applicationContext,
            MessageDatabase::class.java,
            "message_db"
        ).build()
    }
}