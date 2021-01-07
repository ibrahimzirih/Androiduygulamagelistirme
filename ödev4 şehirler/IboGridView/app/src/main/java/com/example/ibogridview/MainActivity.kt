package com.example.ibogridview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_detay.*
import kotlinx.android.synthetic.main.activity_detay.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.view.*;

class MainActivity : AppCompatActivity() {

    var adapter: SehirAdapter? = null
    var sehirlerGridView = ArrayList<Sehir>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sehirlerGridView.add(Sehir("ankara", R.drawable.ankara,400000,33))
        sehirlerGridView.add(Sehir("istanbul", R.drawable.istanbul,400000,33))
        sehirlerGridView.add(Sehir("izmir", R.drawable.izmir,400000,33))
        Sehirler.setOnItemClickListener(AdapterView.OnItemClickListener({ adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
            var it=Intent(this,Detay::class.java)
            it.putExtra("nufus",view1.nufus.text.toString())
            it.putExtra("iklim",view1.iklim.text.toString())
            
        }))
        adapter = SehirAdapter(this, sehirlerGridView)

        Sehirler.adapter=adapter
    }
}