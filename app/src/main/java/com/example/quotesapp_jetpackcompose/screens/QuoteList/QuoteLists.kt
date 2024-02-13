package com.example.quotesapp_jetpackcompose.screens.QuoteList

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quotesapp_jetpackcompose.models.Quote

@Composable
fun QuoteLists(data : List<Quote>, onClick: (quote: Quote)->Unit) {
    LazyColumn(content = {
        items(data){quote ->
            QuoteListItem(quote = quote, onClick)
        }
    })
}