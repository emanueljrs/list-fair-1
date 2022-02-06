package com.emanuel.listfair.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emanuel.listfair.R
import com.emanuel.listfair.model.Item
import kotlinx.android.synthetic.main.list_item.view.*

class ItensListAdapter(private val itens: List<Item>, private val context: Context) : RecyclerView.Adapter<ItensListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itens.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itens[position]
        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item: Item) {
            val itemName = itemView.list_item_name
            val itemQuantity = itemView.list_item_quantity
            val itemValue = itemView.list_item_value

            itemName.text = item.name
            itemQuantity.text = item.quantity.toString()
            itemValue.text = item.value.toString()

        }
    }

}