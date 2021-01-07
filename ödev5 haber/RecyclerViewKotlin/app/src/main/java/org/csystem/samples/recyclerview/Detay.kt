package org.csystem.samples.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Detay : AppCompatActivity() {
    private var haberResim:ImageView?=null
    private var txtIcerik:TextView?=null
    private var txtYazar:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)
        haberResim=findViewById(R.id.HaberBaslikImg)
        txtIcerik=findViewById(R.id.HaberIcerik)
        txtYazar=findViewById(R.id.HaberYazar)
        haberResim?.setImageDrawable(resources.getDrawable(intent.getIntExtra("drawable",-1)))
        txtIcerik?.setText(intent.getStringExtra("icerik"))
        txtYazar?.setText(intent.getStringExtra("yazar"))
    }
}