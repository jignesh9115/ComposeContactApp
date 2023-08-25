package com.jp.composecontactapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jp.composecontactapp.screens.ContactDetail
import com.jp.composecontactapp.screens.ContactListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            DataManager.loadContactFromFile(applicationContext)
        }
        setContent {
            Contacts()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Contacts() {
    if (DataManager.isDataLoaded.value) {

        if (DataManager.currentPage.value == Pages.ContactList) {
            ContactListScreen(data = DataManager.data){
                DataManager.switchPages(it)
            }
        } else {
            DataManager.currentContact?.let { ContactDetail(contactModel = it) }
        }
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(
                text = "Loading...",
                style = MaterialTheme.typography.titleLarge,
            )
        }
    }
}

enum class Pages {
    ContactList,
    ContactDetail
}