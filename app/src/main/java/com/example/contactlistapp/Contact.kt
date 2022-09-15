package com.example.contactlistapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    val name: String,
    val phone: String,
    val photo: String
) : Parcelable

//Parcelize é utilizado para funcionar o tráfego de dados entre as tela/intents
