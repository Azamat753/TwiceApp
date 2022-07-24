package com.siroca.twiceapp.ui.fragment.participants.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.siroca.twiceapp.databinding.ItemParticipantsBinding
import com.example.domain.participants.entity.ParticipantEntity

class ParticipantsAdapter(
    private val listener: Result,
    private val isOpenParticipants: Boolean
) :
    RecyclerView.Adapter<ParticipantsAdapter.ParticipantsViewHolder>() {

    var list = listOf<ParticipantEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ParticipantsViewHolder(private val binding: ItemParticipantsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) = with(binding) {
            imgPart.load(list[position].image)
            txtName.text = list[position].nick_name
            txtJob.text = list[position].position
        }

        fun onClick(position: Int) {
            binding.btnToDetails.setOnClickListener {
                listener.onClickListener(list[position].id)
            }
        }

        fun initHolder() {
            if (!isOpenParticipants) {
                itemView.setPadding(0, 0, 0, 0)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticipantsViewHolder {
        return ParticipantsViewHolder(
            ItemParticipantsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ParticipantsViewHolder, position: Int) {
        holder.initHolder()
        holder.onBind(position)
        holder.onClick(position)
    }

    override fun getItemCount(): Int = list.size

    interface Result {
        fun onClickListener(id: String)
    }

}
