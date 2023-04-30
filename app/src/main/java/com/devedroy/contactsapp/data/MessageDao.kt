package com.devedroy.contactsapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message: MessageModel)

    @Query("SELECT * FROM message_db")
    fun getMessages(): List<MessageModel>

}