package com.siroca.twiceapp.ui.fragment.participants.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.siroca.twiceapp.databinding.ItemParticipantsBinding
import com.example.domain.participants.entity.ParticipantEntity

class ParticipantsAdapter(private val listener: Result) :
    RecyclerView.Adapter<ParticipantsAdapter.ViewHolder>() {

    var list = listOf<ParticipantEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    inner class ViewHolder(private val binding: ItemParticipantsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) = with(binding) {
            imgPart.load(list[position].image)
            txtName.text = list[position].name
            txtJob.text = list[position].position_group
        }

        fun onClick(position: Int) {
            itemView.setOnClickListener {
                listener.onClickListener(list[position].id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemParticipantsBinding.inflate(
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
