package com.siroca.twiceapp.ui.fragment.participants.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.siroca.twiceapp.R
import com.siroca.twiceapp.databinding.ItemParticipantsBinding
import com.siroca.twiceapp.ui.fragment.participants.model.ParticipantsModel

class ParticipantsAdapter(private val listener:Listener) : RecyclerView.Adapter<ParticipantsAdapter.ViewHolder>() {

    private val list = ArrayList<ParticipantsModel>()

    fun getModel(pos: Int): ParticipantsModel{
        return list[pos]
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemParticipantsBinding.bind(view)
        fun bind(list: ParticipantsModel) = with(binding){
            imgPart.setImageResource(list.image)
            txtName.text = list.name
            txtJob.text = list.job
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_participants,
            parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
        holder.binding.btnDetails.setOnClickListener {
            listener.onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addRibbon(model: ParticipantsModel){
        list.add(model)
        notifyDataSetChanged()
    }

    interface Listener{
        fun onClick(pos:Int)
    }

}
