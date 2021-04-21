package com.example.beautysalon.ui.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beautysalon.R

class ListAdapterProfile(private val master: String,
                         private val service: String,
                         private val  time: String) : RecyclerView.Adapter<ListAdapterProfile.MyViewHolder>() {

    override fun getItemCount() = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_view_record,
            parent,
            false
        )

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = master
        holder.services.text = service
        holder.date.text = time

        holder.button.setOnClickListener {
            //TODO сделать отмену записи
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date: TextView = itemView.findViewById(R.id.date)
        val services: TextView = itemView.findViewById(R.id.services)
        val name: TextView = itemView.findViewById(R.id.name)
        val button: Button = itemView.findViewById(R.id.button)
    }
}