package com.example.rsstest3.presentations.frontFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rsstest3.databinding.FragmentFrontBinding
import com.example.rsstest3.model.FrontModel


class FrontAdapter : RecyclerView.Adapter<FrontAdapter.FrontViewHolder>() {


    var model: List<FrontModel> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class FrontViewHolder(binding: FragmentFrontBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: FrontModel) {


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrontViewHolder {
        var binding =
            FragmentFrontBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FrontViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FrontViewHolder, position: Int) {
        holder.bind(model[position])
    }

    override fun getItemCount(): Int = model.size
}