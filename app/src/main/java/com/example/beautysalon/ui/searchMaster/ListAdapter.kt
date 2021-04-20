package com.example.beautysalon.ui.searchMaster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.beautysalon.R

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    override fun getItemCount() = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_view_master,
            parent,
            false
        )

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.city?.text = list[position]
//
//        holder.cardView.setOnClickListener {
//            onItemClickListener.onItemClicked(
//                position,
//                list[position]
//            )
//        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }
}