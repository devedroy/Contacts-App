package com.devedroy.contactsapp

import com.squareup.moshi.Json

data class Contact(
    @Json(name = "fName")
    val fName: String,
    @Json(name = "lName")
    val lName: String
)
