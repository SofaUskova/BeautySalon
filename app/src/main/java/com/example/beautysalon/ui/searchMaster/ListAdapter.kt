package com.example.beautysalon.ui.searchMaster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beautysalon.Master
import com.example.beautysalon.R
import com.example.beautysalon.interfaces.OnItemClickListener

class ListAdapter(
    private val onItemClickListener: OnItemClickListener,
    private val masters: List<Master>
) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    override fun getItemCount() = masters.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_view_master,
            parent,
            false
        )

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = masters[position].name
        holder.shortSkills.text = masters[position].shortSkills.toString()
        holder.imageView.setImageDrawable(masters[position].image)

        holder.button.setOnClickListener {
            onItemClickListener.onItemClicked(
                position,
                masters[position]
            )
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val shortSkills: TextView = itemView.findViewById(R.id.shortSkills)
        val button: Button = itemView.findViewById(R.id.buttonSearchMaster)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}