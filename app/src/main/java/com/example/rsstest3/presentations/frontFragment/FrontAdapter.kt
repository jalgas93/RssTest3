package com.example.rsstest3.presentations.frontFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rsstest3.databinding.ItemFrontFragmentBinding
import com.prof.rssparser.Article
import com.prof.rssparser.Channel


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

        var descriptions = binding.tvDescriptionItemFront

        fun bind(model: Article) {
            Log.i("jalgas1", binding.tvTitleItemFront.toString())



            itemView.setOnClickListener {
                itemClick.invoke(model)
                Log.i("click",it.toString())

            }
            Glide.with(itemView.context).load(model.image).into(binding.ivItemFront)
            title.text = model.title

            descriptions.text = model.description


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