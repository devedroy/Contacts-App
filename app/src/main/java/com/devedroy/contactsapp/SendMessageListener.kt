package com.devedroy.contactsapp

import org.json.JSONObject

interface SendMessageListener {
    fun gotoSendMessageActivity(message: JSONObject)
}