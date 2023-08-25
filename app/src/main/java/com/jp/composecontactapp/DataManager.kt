package com.jp.composecontactapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.jp.composecontactapp.model.ContactModel

/**
 * Created by Jignesh Chauhan on 25-08-2023
 */
object DataManager {

    var data = emptyArray<ContactModel>()
    var isDataLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.ContactList)
    var currentContact: ContactModel? = null

    fun loadContactFromFile(context: Context) {
        val inputStream = context.assets.open("contacts.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val jsonString = String(buffer, Charsets.UTF_8)
        data = Gson().fromJson(jsonString, Array<ContactModel>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(contactModel: ContactModel?) {
        currentPage.value = when (currentPage.value) {
            Pages.ContactList -> {
                currentContact = contactModel
                Pages.ContactDetail
            }

            Pages.ContactDetail -> Pages.ContactList
        }
    }
}