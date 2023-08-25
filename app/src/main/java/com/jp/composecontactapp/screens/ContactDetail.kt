package com.jp.composecontactapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.jp.composecontactapp.DataManager
import com.jp.composecontactapp.model.ContactModel

/**
 * Created by Jignesh Chauhan on 25-08-2023
 */
@Composable
fun ContactDetail(contactModel: ContactModel) {

    BackHandler {
        DataManager.switchPages(null)
    }

    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.radialGradient(
                    colors = listOf(
                        Color.White, Color.LightGray
                    )
                )
            )
    ) {
        Card(
            colors = CardDefaults.cardColors(Color.White),
            modifier = Modifier.padding(15.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(1.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = "contact icon",
                    alignment = Alignment.Center,
                    modifier = Modifier.size(100.dp)
                )
            }

            Column {


                Row(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "Name : ",
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Text(
                        text = contactModel.name,
                        style = MaterialTheme.typography.titleMedium,
                    )
                }
                Row(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "Contact No. : ",
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Text(
                        text = contactModel.contact,
                        style = MaterialTheme.typography.titleMedium,
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly

                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black)
                    ) {
                        Image(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = "Edit Icon",
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = "Edit")
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black)
                    ) {
                        Image(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Edit Icon",
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(
                            text = "Delete",
                        )
                    }
                }
            }
        }

    }
}