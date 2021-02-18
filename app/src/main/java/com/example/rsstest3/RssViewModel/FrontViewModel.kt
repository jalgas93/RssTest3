package com.example.rsstest3.RssViewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rsstest3.util.BASE_URL
import com.prof.rssparser.Parser
import kotlinx.coroutines.launch
import java.nio.charset.Charset

class FrontViewModel(
    var context: Context
):ViewModel() {

    val parser = Parser.Builder()
        .context(context)
        .charset(Charset.forName("ISO-8859-7"))
        .cacheExpirationMillis(24L * 60L * 60L * 100L) // one day
        .build()

    //url of RSS feed
   // private val url = "https://www.androidauthority.com/feed"
    fun a() {
        viewModelScope.launch {
            try {
                val channel = parser.getChannel(BASE_URL)
                // Do something with your data
                Log.i("jalgas",channel.toString())
            } catch (e: Exception) {
                e.printStackTrace()
                // Handle the exception
            }
        }
    }
}