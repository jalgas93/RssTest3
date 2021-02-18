package com.example.rsstest3.presentations.frontFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rsstest3.databinding.ItemFrontFragmentBinding
import com.prof.rssparser.Article
import com.prof.rssparser.Channel


class FrontAdapter : RecyclerView.Adapter<FrontAdapter.FrontViewHolder>() {


    private lateinit var frontItemClick: (Article) -> Unit
    fun setItemClick(itemClick: (article: Article) -> Unit) {
        this.frontItemClick = itemClick
    }


    var model: MutableList<Article> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
            Log.i("model", model.toString())
        }


    inner class FrontViewHolder(val binding: ItemFrontFragmentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var title = binding.tvTitleItemFront

        var descriptions = binding.tvDescriptionItemFront

        fun bind(model: Article) {
            Log.i("jalgas1", binding.tvTitleItemFront.toString())

            title.text = model.title
            descriptions.text = model.link

            Glide.with(itemView.context).load(model.image).into(binding.ivItemFront)

            itemView.setOnClickListener {
                frontItemClick.invoke(model)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrontViewHolder {
        var binding =
            ItemFrontFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FrontViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FrontViewHolder, position: Int) {
        holder.bind(model[position])
    }

    override fun getItemCount(): Int = model.size

}