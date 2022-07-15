package com.siroca.twiceapp.ui.fragment.ribbon.adapter

import android.view.LayoutInflater
import  android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.siroca.twiceapp.databinding.ItemRbBinding
import com.example.domain.ribbon.entity.RibbonEntity

class RibbonAdapter : RecyclerView.Adapter<RibbonAdapter.ViewHolder>() {

    var list = listOf<RibbonEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRbBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: ItemRbBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) = with(binding) {
            rvTwiceImage.load(list[position].image)
            rvTwiceName.text = list[position].name
            rvTwiceDesc.text = list[position].description
        }

    }

}