package com.example.dhmarvel.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dhmarvel.R
import com.example.dhmarvel.entities.Hq
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_hq.view.*

class HqAdapter(val listener: OnclickHqListener): RecyclerView.Adapter<HqAdapter.HqViewHolder>() {

    var listHq = ArrayList<Hq>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HqViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hq, parent, false)
        return HqViewHolder(view)
    }

    override fun onBindViewHolder(holder: HqViewHolder, position: Int) {
        var hq = listHq[position]
        var pathImages = hq.images[0].path
        var extImages = hq.images[0].extension
        Glide.with(holder.itemView).asBitmap()
                .load("${pathImages}.${extImages}")
                .into(holder.ivHq)
        holder.tvHq.text = "#${hq.id}"
    }

    override fun getItemCount() = listHq.size

    fun addList(list: List<Hq>){
        listHq.addAll(list)
        notifyDataSetChanged()
    }

    interface OnclickHqListener{
        fun onClickHq(position: Int)
    }

    inner class HqViewHolder(view: View) :RecyclerView.ViewHolder(view), View.OnClickListener{

        val ivHq: ImageView = view.ivHq
        val tvHq: TextView = view.tvHq

        init{
            view.setOnClickListener(this)
        }

        override fun onClick(v: View){
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION)
                listener.onClickHq(position)
        }

    }
}