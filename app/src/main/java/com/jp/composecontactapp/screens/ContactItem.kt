package com.jp.composecontactapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jp.composecontactapp.DataManager
import com.jp.composecontactapp.model.ContactModel

/**
 * Created by Jignesh Chauhan on 24-08-2023
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactItem(contactModel: ContactModel, onClick: (contactModel: ContactModel) -> Unit) {
    Card(
        modifier = Modifier.padding(10.dp, 10.dp, 10.dp, 0.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(5.dp),
        onClick = {
            onClick(contactModel)
        }
    ) {
        Row(
            modifier = Modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                imageVector = Icons.Rounded.Person,
                contentDescription = "Person Icon",
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.size(5.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = contactModel.name, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "Contact : ${contactModel.contact} ",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.size(5.dp))
            Image(
                imageVector = Icons.Outlined.KeyboardArrowRight,
                contentDescription = "edit icon",
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.size(5.dp))
        }
    }
}


