package org.csystem.samples.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mEditTextRemove: EditText
    private lateinit var mHabers: ArrayList<Haber>
    //private lateinit var mAdapter: RecyclerView.Adapter<BookAdapter.BookViewHolder>
    private lateinit var mAdapter: HaberAdapter
    private lateinit var mLayoutManager: RecyclerView.LayoutManager

    private fun init()
    {
        initViews()
    }

    private fun initViews()
    {
        mHabers = ArrayList()
        mHabers.add(Haber(R.drawable.haber, "Fenerbahce 10-0 yenildi!!", "Gokmen Ozdenak"))
        mHabers.add(Haber(R.drawable.haber2, "Fenerbahce 3.lige düstü!!", "Gokmen Ozdenak"))

        mLayoutManager = LinearLayoutManager(this)
        mAdapter = HaberAdapter(mHabers)

        mRecyclerView = findViewById(R.id.mainActivityRecyclerview)
        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.adapter = mAdapter

        mAdapter.setOnClickListener(
                object : HaberAdapter.OnItemClickListener {
                    override fun onItemClick(position: Int)
                    {
                        var it=Intent(this@MainActivity,Detay::class.java)
                        it.putExtra("drawable",mHabers[position].imageSrcId)
                        it.putExtra("icerik",mHabers[position].Baslik)
                        it.putExtra("yazar",mHabers[position].author)
                        startActivity(it)
                    }
                }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
}
