package com.jp.composecontactapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.jp.composecontactapp.model.ContactModel

/**
 * Created by Jignesh Chauhan on 25-08-2023
 */

@Composable
fun ContactLists(data: Array<ContactModel>, onClick: (contact: ContactModel) -> Unit) {
    LazyColumn(content = {
        items(data) {
            ContactItem(contactModel = it, onClick)
        }
    })
}