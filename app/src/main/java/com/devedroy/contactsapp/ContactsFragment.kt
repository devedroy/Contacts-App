package com.devedroy.contactsapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devedroy.contactsapp.databinding.FragmentContactsBinding
import okio.IOException
import org.json.JSONArray

class ContactsFragment : Fragment() {
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
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val fName = jsonObject.getString("fName")
                val lName = jsonObject.getString("lName")
                Log.d(TAG, "$fName")
                Log.d(TAG, "$lName")
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return contactsBinding.root
    }
}