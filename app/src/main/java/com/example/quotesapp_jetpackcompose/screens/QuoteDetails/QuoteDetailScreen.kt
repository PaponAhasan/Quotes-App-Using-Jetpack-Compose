package com.example.quotesapp_jetpackcompose.screens.QuoteDetails

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.quotesapp_jetpackcompose.data.DataManage
import com.example.quotesapp_jetpackcompose.R
import com.example.quotesapp_jetpackcompose.models.Quote

@Composable
fun QuoteDetailScreen(quote: Quote) {
    BackHandler {
        DataManage.switchPages(null)
    }

    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3),
                    )
                )
            ),
        contentAlignment = Alignment.Center

    ) {

        Image(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.TopStart)
                .clickable {
                    DataManage.switchPages(null)
                }
        )

        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier.padding(32.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White, //Card background color
                //contentColor = Color.White  //Card content color,e.g.text
            ),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp, 24.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180F)
                )
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.headlineSmall,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular))
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular))
                )
            }
        }
    }
}