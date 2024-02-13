package com.example.quotesapp_jetpackcompose

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.example.quotesapp_jetpackcompose.models.Quote
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.FileNotFoundException

object DataManage {

    var data = emptyList<Quote>()
    var isDataLoaded = mutableStateOf(false)
    fun lodeAssetsFromFile(context: Context) {
        try {
            val jsonString = readJsonFromAssets(context, "quotes.json")
            val bookList = parseJsonToModel(jsonString)
            data = bookList
            isDataLoaded.value = true
        } catch (e: FileNotFoundException) {
            // Handle the file not found error here
            Log.e("LoadAssets", "File not found: ${e.message}")
            isDataLoaded.value = false
        }
    }
}

fun readJsonFromAssets(context: Context, fileName: String): String {
    return context.assets.open(fileName).bufferedReader().use { it.readText() }
}

fun parseJsonToModel(jsonString: String): List<Quote> {
    val gson = Gson()
    return gson.fromJson(jsonString, object : TypeToken<List<Quote>>() {}.type)
}