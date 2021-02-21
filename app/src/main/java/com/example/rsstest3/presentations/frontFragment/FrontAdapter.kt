package com.example.rsstest3.presentations.frontFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rsstest3.R
import com.example.rsstest3.databinding.ItemFrontFragmentBinding
import com.prof.rssparser.Article
import com.prof.rssparser.Channel
import com.prof.rssparser.Image
import java.text.SimpleDateFormat
import java.util.*


class FrontAdapter : RecyclerView.Adapter<FrontAdapter.FrontViewHolder>() {

    var model: MutableList<Article> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
            Log.i("model", model.toString())
        }

    private lateinit var itemClick: (Article) -> Unit
    fun setItemClick(itemClick: (article: Article) -> Unit) {
        this.itemClick = itemClick
    }

    inner class FrontViewHolder(val binding: ItemFrontFragmentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var title = binding.tvTitleItemFront
        var author = binding.tvAuthorItemFront
        var data = binding.tvDataItemFront


        fun bind(model: Article) {
            Log.i("jalgas1", binding.tvTitleItemFront.toString())
            title.text = model.title
            author.text = model.author
            var dataFinish = model.pubDate

            try {
                val data = model.pubDate
                val sourceSdf = SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH)
                if (data != null) {
                    val date = sourceSdf.parse(data)
                    if (date != null) {
                        val sdf = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
                        dataFinish = sdf.format(date)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            data.text = dataFinish
            Log.i("image", model.title.toString())
            Log.i("image", model.description.toString())
            Log.i("image", model.author.toString())
            Log.i("image", model.pubDate.toString())
            Log.i("image", model.audio.toString())
            Log.i("image", model.content.toString())
            Log.i("image", model.guid.toString())
            Log.i("image", model.sourceName.toString())
            Log.i("image", model.sourceUrl.toString())
            Log.i("image", model.video.toString())
            Log.i("image", model.image.toString())
            Log.i("image", model.link.toString())
            Log.i("image", model.categories.toString())

            Glide.with(itemView.context).load(model.image).into(binding.ivItemFront)
            itemView.setOnClickListener {
                itemClick.invoke(model)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrontViewHolder {
        var binding = ItemFrontFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FrontViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FrontViewHolder, position: Int) {
        holder.bind(model[position])
    }

    override fun getItemCount(): Int = model.size
}