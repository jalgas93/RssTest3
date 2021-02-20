package com.example.rsstest3.RssViewModel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.example.rsstest3.model.Channel
import com.example.rsstest3.repository.Repository

import com.example.rsstest3.util.BASE_URL

import com.prof.rssparser.Parser

import kotlinx.coroutines.launch
import java.nio.charset.Charset


class FrontViewModel(

var  repository: Repository
) : ViewModel() {

    private val rssLiveData: MutableLiveData<Channel> = MutableLiveData()
    val liveData: LiveData<Channel> = rssLiveData

    private val _rssChannelGetUrl = MutableLiveData<List<Channel>>()
    val rssChannelGetUrl: LiveData<List<Channel>>
        get() = _rssChannelGetUrl


    fun insertUrl(channel:com.example.rsstest3.model.Channel){
        viewModelScope.launch {
            repository.insertUrl(channel)
        }
    }

    fun getUrl(){
        viewModelScope.launch {
            repository.getUrl()

            _rssChannelGetUrl.value = repository.getUrl()
            Log.i("jalgas1",repository.getUrl().toString())


        }
    }
    //url of RSS feed
    val parser = Parser.Builder()
        // .context()
        .charset(Charset.forName("ISO-8859-7"))
        .cacheExpirationMillis(24L * 60L * 60L * 100L) // one day
        .build()


  //   private val url = "https://www.androidauthority.com/feed"
   // private val url = "https://gravitec.net/blog/feed/"
    fun initialUrl(url:String) {
        viewModelScope.launch {
            try {
                val channel =  parser.getChannel(url)
                // Do something with your data
                Log.i("jalgas", channel.toString())
              //  rssLiveData.postValue(channel)
                //rssLiveData.value = channel

            } catch (e: Exception) {
                e.printStackTrace()
                // Handle the exception
            }
        }


  }




}