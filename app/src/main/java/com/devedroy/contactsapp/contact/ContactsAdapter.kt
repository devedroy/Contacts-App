package com.devedroy.contactsapp.contact

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.devedroy.contactsapp.R
import com.devedroy.contactsapp.databinding.ItemContactBinding
import org.json.JSONArray
import org.json.JSONObject

class ContactsAdapter(
    private val context: Context,
    private val jsonArray: JSONArray
) :
    RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    inner class ContactViewHolder(private val binding: ItemContactBinding) :
        ViewHolder(binding.root) {
        fun bind(jsonObject: JSONObject) {
            val name = jsonObject.getString("fName") + " " + jsonObject.getString("lName")
            binding.root.text = name
            binding.root.setOnClickListener {
                val dialog = Dialog(context)
                dialog.setContentView(R.layout.contact_detail_dialog)
                dialog.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                val btnMessage = dialog.findViewById<Button>(R.id.btnMessage)
                btnMessage.setOnClickListener {
                    Toast.makeText(context, "Sending Message", Toast.LENGTH_SHORT).show()
                }
                dialog.show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int = jsonArray.length()

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) =
        holder.bind(jsonArray.getJSONObject(position))
}