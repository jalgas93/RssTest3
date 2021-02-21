package com.example.rsstest3.presentations.firstFrontFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rsstest3.databinding.ItemAddChannelBinding

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

    inner class AddChannelViewHolder(val binding: ItemAddChannelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var title = binding.tvAddChannel
        var description = binding.tvDescriptionAddChannel

        fun bind(channel: com.prof.rssparser.Channel) {
            title.text = channel.link
            Log.i("jalgas5",channel.link.toString())
            description.text = channel.description

            itemView.setOnClickListener {
                itemClickAddChannel.invoke(channel)
            }
            binding.btnAddChannel.setOnClickListener {
                itemDelete.invoke(channel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddChannelViewHolder {
        var binding = ItemAddChannelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddChannelViewHolder(binding)
    }
    override fun onBindViewHolder(holder: AddChannelViewHolder, position: Int) {
        holder.bind(model[position])
    }
    override fun getItemCount(): Int = model.size
}