package com.siroca.twiceapp.ui.fragment.ribbon.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import  android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.siroca.twiceapp.R
import com.siroca.twiceapp.databinding.ItemRbBinding
import com.siroca.twiceapp.ui.fragment.ribbon.model.RibbonModel

class RibbonAdapter : RecyclerView.Adapter<RibbonAdapter.ViewHolder>() {

    private val list = ArrayList<RibbonModel>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemRbBinding.bind(view)
                fun bind(list: RibbonModel) = with(binding){
                    rvTwiceImage.setImageResource(list.image)
                    rvTwiceName.text = list.name
                    rvTwiceDesc.text = list.description
                }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rb, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addRibbon(model: RibbonModel){
        list.add(model)
        notifyDataSetChanged()
    }
}