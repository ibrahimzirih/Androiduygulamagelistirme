package com.example.ibogridview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.list_item.view.*;

class SehirAdapter : BaseAdapter {
    var sehirList = ArrayList<Sehir>()
    var context: Context? = null

    constructor(context: Context, fruitList: ArrayList<Sehir>) : super() {
        this.context = context
        this.sehirList = fruitList
    }

    override fun getCount(): Int {
        return sehirList.size
    }

    override fun getItem(position: Int): Any {
        return sehirList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val fruit = this.sehirList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var listItemView = inflator.inflate(R.layout.list_item, null)
        listItemView.fruitName.text = fruit.name!!
        listItemView.fruitImage.setImageResource(fruit.image!!)

        listItemView.fruitImage.setOnClickListener {
            println("Current fruit : ${fruit.toString()}")
        }

        return listItemView
    }
}