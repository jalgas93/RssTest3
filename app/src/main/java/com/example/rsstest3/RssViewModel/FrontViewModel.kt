package com.example.rsstest3.RssViewModel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*

import com.example.rsstest3.util.BASE_URL
import com.prof.rssparser.Channel
import com.prof.rssparser.Parser

import kotlinx.coroutines.launch
import java.nio.charset.Charset


class FrontViewModel(
     application: Application
 //   var context: Context
) : AndroidViewModel(application) {

    private val rssLiveData: MutableLiveData<Channel> = MutableLiveData()
    val liveData: LiveData<Channel> = rssLiveData

    private val _rssChannel = MutableLiveData<Channel>()
    val rssChannel: LiveData<Channel>
        get() = _rssChannel

    val parser = Parser.Builder()
        .context(application)
        .charset(Charset.forName("ISO-8859-7"))
        .cacheExpirationMillis(24L * 60L * 60L * 100L) // one day
        .build()


    //url of RSS feed


  //   private val url = "https://www.androidauthority.com/feed"
    private val url = "https://gravitec.net/blog/feed/"
    fun a() {
        viewModelScope.launch {
            try {
                val channel = parser.getChannel(url)
                // Do something with your data
                Log.i("jalgas", channel.toString())
              //  rssLiveData.postValue(channel)
                rssLiveData.value = channel

            } catch (e: Exception) {
                e.printStackTrace()
                // Handle the exception
            }
        }
  }
}