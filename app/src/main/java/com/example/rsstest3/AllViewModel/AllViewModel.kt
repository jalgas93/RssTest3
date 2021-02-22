package com.example.rsstest3.AllViewModel

import android.util.Log
import androidx.lifecycle.*
import com.example.rsstest3.model.UrlAddress
import com.example.rsstest3.repository.Repository

import com.prof.rssparser.Article

import com.prof.rssparser.Parser
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request


class AllViewModel(
    var repository: Repository
) : ViewModel() {
    private val articleMutableLiveData: MutableLiveData<MutableList<Article>> = MutableLiveData()
    val articleLiveData: LiveData<MutableList<Article>> = articleMutableLiveData

    private val getUrlAddressMutLive = MutableLiveData<UrlAddress>()
    val getUrlAddressLiveData: LiveData<UrlAddress>
        get() = getUrlAddressMutLive

    private val channelMutableLiveData = MutableLiveData<List<com.prof.rssparser.Channel>>()
    val channelLiveData: LiveData<List<com.prof.rssparser.Channel>> = channelMutableLiveData


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
    fun insertUrlAddress(urlAddress: UrlAddress) {
        viewModelScope.launch {
            repository.insertUrlAddress(urlAddress)
        }
    }

    fun getUrlAddress() = repository.getUrlAddress()




//    fun deleteItem(channel: Channel) {
//        viewModelScope.launch {
//            repository.deleteItem(channel)
//        }
//    }
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


    fun ArticleFunction(url: String) {
        val parser = Parser.Builder().build()

        viewModelScope.launch(Dispatchers.IO) {
            val request = Request.Builder()
                .url(url)
                .build()
            val result = okHttpClient.newCall(request).execute()
            val raw = runCatching { result.body?.string() }.getOrNull()
            if (raw == null) {
                articleMutableLiveData.postValue(raw)
            } else {
                val channel = parser.parse(raw)
                articleMutableLiveData.postValue(channel.articles)
                Log.i("jalgas11", channel.toString())
            }
        }
    }
    fun ChannelFunction(url: String) {
        val parser = Parser.Builder().build()

        viewModelScope.launch(Dispatchers.IO) {
            val request = Request.Builder()
                .url(url)
                .build()
            val result = okHttpClient.newCall(request).execute()
            val raw = runCatching { result.body?.string() }.getOrNull()
            if (raw == null) {
                channelMutableLiveData.postValue(raw)
            } else {
                val channel = parser.parse(raw)
                channelMutableLiveData.postValue(listOf(channel))
                Log.i("jalgas11", channel.toString())
            }
        }
    }
}