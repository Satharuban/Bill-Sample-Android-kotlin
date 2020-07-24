package com.example.myapplication2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Item
import com.example.myapplication.R

class ItemAdapter(val itemlist: ArrayList<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName = itemView.findViewById<TextView>(R.id.Item_name)
        val itemCount = itemView.findViewById<TextView>(R.id.Item_Count)
        val itemUnitPrice = itemView.findViewById<TextView>(R.id.Item_Unit_Price)
        val itemPrice = itemView.findViewById<TextView>(R.id.Item_Price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_sample, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
       return itemlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var quantity =itemlist[position].item_count.toString()
        var uprice=itemlist[position].item_unit_price.toString()
        holder?.itemName?.text = itemlist[position].item_name
        holder?.itemCount?.text = itemlist[position].item_count.toString()
        holder?.itemUnitPrice?.text = itemlist[position].item_unit_price.toString()
        var total= ("$quantity".toInt())*("$uprice".toInt())
        holder?.itemPrice?.text =total.toString()
    }

}