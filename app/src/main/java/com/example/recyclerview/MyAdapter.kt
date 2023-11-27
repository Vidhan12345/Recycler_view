package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var newUserDetails : ArrayList<UserModel>,var context: Context):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        var currentItem = newUserDetails[position]
        holder.image.setImageResource(currentItem.image)
        holder.name.text = currentItem.name
        holder.age.text = currentItem.age.toString()
        holder.sec.text = currentItem.sec

    }

    override fun getItemCount(): Int {
        return newUserDetails.size
    }

    class MyViewHolder (var itemView : View) : RecyclerView.ViewHolder(itemView){
        var image = itemView.findViewById<ImageView>(R.id.img)
        var name = itemView.findViewById<TextView>(R.id.name)
        var age = itemView.findViewById<TextView>(R.id.age)
        var sec = itemView.findViewById<TextView>(R.id.sec)


    }

}