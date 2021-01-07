package com.example.uyelik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun kayit(view:View){
        val ad=findViewById<EditText>(R.id.ad)
        val soyad=findViewById<EditText>(R.id.soyad)
        val yas=findViewById<EditText>(R.id.yas)
        val eposta=findViewById<EditText>(R.id.eposta)
        val sifre=findViewById<EditText>(R.id.sifre)
        val sifreTekrar=findViewById<EditText>(R.id.sifreTekrar)
        val index=eposta.text.indexOf("@")
        if(!(ad.text.all { it.isLetterOrDigit() }&&ad.text.length>=2)) {
            Toast.makeText(this.getApplicationContext(), "yanlis ad girdiniz", Toast.LENGTH_SHORT).show()
            return
        }
        if(!(soyad.text.all { it.isLetterOrDigit() }&&soyad.text.length>=2)) {
            Toast.makeText(this.getApplicationContext(), "yanlis soyad girdiniz", Toast.LENGTH_SHORT).show()
            return
        }
        try{
            val yasInt=yas.text.toString().toInt()
            if(!(yasInt>=18&&yasInt<=100)){
                Toast.makeText(this.getApplicationContext(), "yas bilgisini yanlis girdiniz", Toast.LENGTH_SHORT).show()
                return
            }
        }catch (e:Exception){
            Toast.makeText(this.getApplicationContext(), "yas bilgisini yanlis girdiniz", Toast.LENGTH_SHORT).show()
            return
        }
        if(index==-1||index==eposta.text.length||index==0||eposta.text.length<5){
            Toast.makeText(this.getApplicationContext(), "eposta formati hatalidir", Toast.LENGTH_SHORT).show()
            return
        }
        if(sifre.text.length<5){
            Toast.makeText(this.getApplicationContext(), "sifre en az 5 karakterden olusmalidir", Toast.LENGTH_SHORT).show()
            return
        }
        if(!sifreTekrar.text.toString().equals(sifre.text.toString())){
            Toast.makeText(this.getApplicationContext(), "girilen sifreler uyusmuyor", Toast.LENGTH_SHORT).show()
            return
        }
        Toast.makeText(this.getApplicationContext(), "uyelik yapildi", Toast.LENGTH_SHORT).show()
    }
}