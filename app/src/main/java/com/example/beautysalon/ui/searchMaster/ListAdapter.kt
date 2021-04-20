package com.example.beautysalon.ui.searchMaster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.beautysalon.R
import com.example.beautysalon.interfaces.OnItemClickListener

class ListAdapter(private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

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

        holder.button.setOnClickListener {
            onItemClickListener.onItemClicked(
                position,
                1
            //list[position]
            )
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.buttonSearchMaster)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }
}