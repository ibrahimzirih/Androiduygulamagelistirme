package com.example.ibogridview

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detay.view.*;
class Detay : AppCompatActivity() {
    private var nufus: String? = null
    private var iklim: String? = null
    private var gorsel:Drawable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)
        intent.getIntExtra("nufus",-1)
        intent.getIntExtra("iklim",-1)

    }
}