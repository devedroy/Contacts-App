package com.devedroy.contactsapp.contact

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devedroy.contactsapp.SendMessageActivity
import com.devedroy.contactsapp.SendMessageListener
import com.devedroy.contactsapp.databinding.FragmentContactsBinding
import org.json.JSONArray
import java.io.IOException

class ContactsFragment : Fragment(), SendMessageListener {
    private lateinit var contactsBinding: FragmentContactsBinding
    val TAG = "ContactsFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contactsBinding = FragmentContactsBinding.inflate(layoutInflater, container, false)
        try {
            val inputStream = context?.assets?.open("contacts_v2.json")
            val jsonString = inputStream?.bufferedReader().use { it?.readText() ?: "MyName" }
            val jsonArray = JSONArray(jsonString)
            contactsBinding.rvContactList.adapter =
                ContactsAdapter(requireContext(), jsonArray, this@ContactsFragment)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return contactsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun gotoSendMessageActivity() {
        startActivity(Intent(activity, SendMessageActivity::class.java))
    }
}