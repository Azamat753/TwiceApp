package com.siroca.twiceapp.ui.fragment.albums.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.domain.albums.entity.AlbumsEntity
import com.example.domain.participants.entity.ParticipantEntity
import com.siroca.twiceapp.databinding.ItemAlbumsBinding
import com.siroca.twiceapp.databinding.ItemParticipantsBinding
import com.siroca.twiceapp.ui.fragment.albums.AlbumsFragment

class AlbumsAdapter(private val listener: AlbumsFragment):
    RecyclerView.Adapter<AlbumsAdapter.ViewHolder>(){

    var list = listOf<AlbumsEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(private val binding: ItemAlbumsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) = with(binding) {
            itemAlbumImg.load(list[position].Image)
            itemAlbumName.text = list[position].Name
        }

        fun onClick(position: Int) {
            itemView.setOnClickListener {
                listener.onClickListener(list[position].id)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAlbumsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
        holder.onClick(position)
    }

    override fun getItemCount(): Int = list.size

    interface Result {
        fun onClickListener(id: String)
    }
}