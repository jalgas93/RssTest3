package com.example.rsstest3.presentations.firstFrontFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rsstest3.databinding.FragmentAddChannelBinding
import com.example.rsstest3.databinding.ItemAddChannelBinding
import com.example.rsstest3.model.Channel

class AddChannelAdapter() : RecyclerView.Adapter<AddChannelAdapter.AddChannelViewHolder>() {



    var model: List<Channel> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private lateinit var itemClickAddChannel: (Channel) -> Unit
    fun setItemAddChannel(itemClickAddChannel: (channel: Channel) -> Unit) {
        this.itemClickAddChannel = itemClickAddChannel
    }

    inner class AddChannelViewHolder(val binding: ItemAddChannelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var title = binding.tvAddChannel
        var description = binding.tvDescriptionAddChannel

        fun bind(channel: Channel) {
            title.text = channel.link
            Log.i("link",channel.link.toString())
            description.text = channel.description


           // Glide.with(itemView.context).load(channel.image).into(binding.ivAddChannel)

            itemView.setOnClickListener {
                itemClickAddChannel.invoke(channel)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddChannelViewHolder {
        var binding =
            ItemAddChannelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddChannelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddChannelViewHolder, position: Int) {
        holder.bind(model[position])
    }

    override fun getItemCount(): Int = model.size
}