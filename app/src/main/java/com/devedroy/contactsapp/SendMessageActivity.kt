package com.devedroy.contactsapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.devedroy.contactsapp.data.MessageModel
import com.devedroy.contactsapp.databinding.ActivitySendMessageBinding
import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.util.Random

class SendMessageActivity : AppCompatActivity() {
    private lateinit var messageBinding: ActivitySendMessageBinding
    private val coroutineScope = CoroutineScope(Dispatchers.Main)


    private val ACCOUNT_SID = "ACb3387e6829d36e4c73d40f859874741d"
    private val AUTH_TOKEN = "74f795674b090fbe1ad120d5ff43901c"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        messageBinding = ActivitySendMessageBinding.inflate(layoutInflater)
        setContentView(messageBinding.root)

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN)

        messageBinding.btnSendMessage.setOnClickListener { view ->
            Toast.makeText(
                this,
                "Message sent",
                Toast.LENGTH_LONG
            ).show()
            sendMessage()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
    }

    private fun sendMessage() {
        updateLocalDb()
//        configureTwilio()
    }
    private fun updateLocalDb() {
        val message = MessageModel(
            "Devpreyo Roy",
            123456,
            "10:30 AM"
        )
        coroutineScope.launch {
            App.messageDatabase.messageDao().insertMessage(message)
        }
    }

    private fun configureTwilio() {
        val random = Random()
        val randomInt = random.nextInt(900000) + 100000
        val msg = "Hi. Your OTP is $randomInt"
        val message = Message.creator(
            PhoneNumber("+919959570184"),
            PhoneNumber("+16205269258"),
            msg
        )
            .create()

        Log.d("SendMessageActivity", message.sid)
    }


}