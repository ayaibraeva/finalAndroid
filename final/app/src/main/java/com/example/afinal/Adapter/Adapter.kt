package com.example.afinal.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.MainActivity
import com.example.afinal.R

class Adapter(val context: Context):RecyclerView.Adapter<Adapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false)
        instance = this
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return MainActivity.news.size
    }

    override fun onBindViewHolder(holder: Adapter.MyViewHolder, position: Int) {
        val new = MainActivity.news[position]
        holder.titleText.text = new.title


        holder.itemView.setOnClickListener {

            it.findNavController().navigate(R.id.action_firstFragment_to_newsDetailFragment)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleText: TextView = itemView.findViewById(R.id.titleTextView)

    }


    companion object {
        lateinit var instance: Adapter
    }
}