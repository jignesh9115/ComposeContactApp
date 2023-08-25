package com.jp.composecontactapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jp.composecontactapp.model.ContactModel

/**
 * Created by Jignesh Chauhan on 25-08-2023
 */
@Composable
fun ContactListScreen(data: Array<ContactModel>, onClick: (contact: ContactModel) -> Unit) {
    Column {
        Text(
            text = "Contacts",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp, 15.dp)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.titleLarge,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold
        )

        ContactLists(data = data, onClick)

    }
}