package com.devedroy.contactsapp.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devedroy.contactsapp.App
import com.devedroy.contactsapp.data.MessageModel
import com.devedroy.contactsapp.databinding.FragmentMessagesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MessagesFragment : Fragment() {
    private lateinit var messageBinding: FragmentMessagesBinding
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        messageBinding = FragmentMessagesBinding.inflate(layoutInflater, container, false)
        setUpView()
        return messageBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
    }

    private fun setUpView() {
        coroutineScope.launch {
            val messages = getMessages()
            messageBinding.rvMessageList.adapter = MessagesAdapter(messages)
        }
    }

    private suspend fun getMessages(): List<MessageModel> = withContext(Dispatchers.Main) {
        App.messageDatabase.messageDao().getMessages()
    }

}