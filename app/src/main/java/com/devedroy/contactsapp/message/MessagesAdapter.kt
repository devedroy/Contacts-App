package com.devedroy.contactsapp.message

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devedroy.contactsapp.data.MessageModel
import com.devedroy.contactsapp.databinding.ItemMessageBinding

class MessagesAdapter(private val messageList: List<MessageModel>) :
    RecyclerView.Adapter<MessagesAdapter.MessageViewHolder>() {
    inner class MessageViewHolder(private val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: MessageModel) {
            binding.tvOtp.text = message.otp.toString()
            binding.tvName.text = message.name
            binding.tvTime.text = message.time
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val binding = ItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MessageViewHolder(binding)
    }

    override fun getItemCount(): Int = messageList.size

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) =
        holder.bind(messageList[position])
}