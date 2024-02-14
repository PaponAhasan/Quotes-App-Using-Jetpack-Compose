package com.example.quotesapp_jetpackcompose

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
import com.example.quotesapp_jetpackcompose.screens.QuoteDetails.QuoteDetailScreen
import com.example.quotesapp_jetpackcompose.screens.QuoteList.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            DataManage.lodeAssetsFromFile(applicationContext, "quotes.json")
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if (DataManage.isDataLoaded.value) {
        if(DataManage.currentScreen.value == Pages.LISTING){
            QuoteListScreen(data = DataManage.data) {
                DataManage.switchPages(it)
            }
        }else{
            DataManage.currentQuote?.let { QuoteDetailScreen(quote = it) }
        }
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(
                text = "Loading.....",
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

enum class Pages{
    LISTING,
    DETAIL
}

