package com.example.rsstest3.AllViewModel

import android.util.Log
import androidx.lifecycle.*
import com.example.rsstest3.model.Channel
import com.example.rsstest3.model.UrlAddress
import com.example.rsstest3.repository.Repository

import com.prof.rssparser.Article

import com.prof.rssparser.Parser
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import java.nio.charset.Charset


class AllViewModel(

var  repository: Repository
) : ViewModel() {

    private val rssLiveData: MutableLiveData<List<com.prof.rssparser.Channel>> = MutableLiveData()
    val liveData: LiveData<List<com.prof.rssparser.Channel>> = rssLiveData

    private val _rssChannelGetUrl = MutableLiveData<UrlAddress>()
    val rssChannelGetUrl: LiveData<UrlAddress>
        get() = _rssChannelGetUrl


//    fun insertUrl(channel:com.example.rsstest3.model.Channel){
//        viewModelScope.launch {
//            repository.insertUrl(channel)
//        }
//    }
//
//    fun getUrl(){
//        viewModelScope.launch {
//            repository.getUrl()
//
//            _rssChannelGetUrl.value = repository.getUrl()
//            Log.i("jalgas3",repository.getUrl().toString())
//
//
//        }
//    }
    fun insertUrlAddress(urlAddress: UrlAddress){
        viewModelScope.launch {
            repository.insertUrlAddress(urlAddress)
        }
    }

    fun getUrlAddress(){
        viewModelScope.launch {
            _rssChannelGetUrl.value = repository.getUrlAddress()

        }
    }

    fun deleteItem(channel:Channel){
        viewModelScope.launch {
            repository.deleteItem(channel)
        }
    }
//    val parser = Parser.Builder()
//        //.context(re)
//        .charset(Charset.forName("ISO-8859-7"))
//        .cacheExpirationMillis(24L * 60L * 60L * 100L) // one day
//        .build()

//    fun initialUrl(url:String) {
//      viewModelScope.launch {
//          try {
//              val channel = parser.getChannel(url)
//              // Do something with your data
//              Log.i("jalgas2", channel.toString())
//              // rssLiveData.value = channel.articles
//
//
//          } catch (e: Exception) {
//              e.printStackTrace()
//              // Handle the exception
//          }
//      }
//
//  }
       val okHttpClient by lazy {
          OkHttpClient()
      }
      fun fetchForUrlAndParseRawData(url: String) {
          val parser = Parser.Builder().build()

          viewModelScope.launch(Dispatchers.IO) {
              val request = Request.Builder()
                  .url(url)
                  .build()
              val result = okHttpClient.newCall(request).execute()
              val raw = runCatching { result.body?.string() }.getOrNull()
              if (raw == null) {
                rssLiveData.value = raw
              } else {
                  val channel = parser.parse(raw)
                  rssLiveData.value = listOf(channel)
                  Log.i("jalgas11",channel.toString())
              }
          }
  }
}