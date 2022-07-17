package com.siroca.twiceapp.ui.fragment.photo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.siroca.twiceapp.R
import com.siroca.twiceapp.databinding.ItemForViewPagerBinding

class AdapterForViewPager(private var image: List<Int>):
    RecyclerView.Adapter<AdapterForViewPager.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(item: View):RecyclerView.ViewHolder(item){

        val itemImage : ImageView = item.findViewById(R.id.img_first_top)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterForViewPager.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_for_view_pager, parent, false))
    }

    override fun onBindViewHolder(holder: AdapterForViewPager.Pager2ViewHolder, position: Int) {
       holder.itemImage.setImageResource(image[position])
    }

    override fun getItemCount(): Int {
        return image.size
    }

}
