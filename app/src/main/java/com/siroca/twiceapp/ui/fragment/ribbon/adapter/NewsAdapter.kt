package com.siroca.twiceapp.ui.fragment.ribbon.adapter

import android.view.LayoutInflater
import  android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.siroca.twiceapp.databinding.ItemRbBinding
import com.example.domain.news.entity.NewsEntity

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var list = listOf<NewsEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ItemRbBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = list.size

    inner class NewsViewHolder(private val binding: ItemRbBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) = with(binding) {
            itemTwiceImage.load(list[position].image)
            itemTwiceName.text = list[position].title
            itemTwiceDesc.text = list[position].description
        }

    }

}