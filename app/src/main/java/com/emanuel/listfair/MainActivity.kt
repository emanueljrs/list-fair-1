package com.emanuel.listfair

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emanuel.listfair.model.Item
import com.emanuel.listfair.ui.adapter.ItensListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var itens = mutableListOf<Item>()
    private lateinit var recyclerView: RecyclerView
    private var totalValue = 0.0
    private var quantities = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAdd.setOnClickListener { addNotes() }

        recyclerView = item_list_recyclerview
        recyclerView.adapter = ItensListAdapter(itensList(), this)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }

    private fun addNotes() {
        val name = editName.text.toString()
        val quantity = editQuantity.text.toString().toInt()
        val value = editValue.text.toString().toDouble()
        val item = Item(name, quantity, value)

        itens.add(item)
        recyclerView.adapter?.notifyDataSetChanged()

        updateTotals(quantity, value)
        clearFields()
    }

    private fun itensList(): List<Item> {
        return itens
    }

    private fun updateTotals(qntd: Int, value: Double) {
        totalValue += qntd * value
        quantities += qntd
        textTotal.text = "Total R$ %.2f".format(totalValue)
        textQuantity.text = "Quantidade itens: $quantities"
    }

    private fun clearFields() {
        editName.text.clear()
        editQuantity.text.clear()
        editValue.text.clear()

        editName.requestFocus()
    }
}