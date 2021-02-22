package com.example.rsstest3.presentations.firstFrontFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rsstest3.databinding.ItemChannelBinding
import com.squareup.picasso.Picasso


class AddChannelAdapter() : RecyclerView.Adapter<AddChannelAdapter.AddChannelViewHolder>() {



    var model: List<com.prof.rssparser.Channel> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private lateinit var itemDelete:(com.prof.rssparser.Channel)->Unit
    fun setDeleteItem(itemDelete:(channel:com.prof.rssparser.Channel)->Unit){
        this.itemDelete = itemDelete
    }

    private lateinit var itemClickAddChannel: (com.prof.rssparser.Channel) -> Unit
    fun setItemAddChannel(itemClickAddChannel: (channel: com.prof.rssparser.Channel) -> Unit) {
        this.itemClickAddChannel = itemClickAddChannel
    }

    inner class AddChannelViewHolder(val binding: ItemChannelBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var title = binding.tvDescChannel



        fun bind(channel: com.prof.rssparser.Channel) {
         title.text = channel.description

//            Glide.with(itemView.context).load(channel.image).into(binding.image)
            Picasso.get().load(channel.image!!.url).into(binding.ivItemChannel)
            itemView.setOnClickListener {
                itemClickAddChannel.invoke(channel)
            }
//            binding.btnAddChannel.setOnClickListener {
//                itemDelete.invoke(channel)
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddChannelViewHolder {
        var binding = ItemChannelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddChannelViewHolder(binding)
    }
    override fun onBindViewHolder(holder: AddChannelViewHolder, position: Int) {
        holder.bind(model[position])
    }
    override fun getItemCount(): Int = model.size
}