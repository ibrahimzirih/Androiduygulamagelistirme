package org.csystem.samples.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HaberAdapter(private val habers: ArrayList<Haber>): RecyclerView.Adapter<HaberAdapter.HaberViewHolder>() {
    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
        {

        }
    }

    fun setOnClickListener(listener: OnItemClickListener)
    {
        mListener = listener
    }

    inner class HaberViewHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        var mImage: ImageView
        var mHaberBaslik: TextView
        var mHaberIcerik: TextView

        init {
            mImage = itemView.findViewById(R.id.imageViewHaber)
            mHaberBaslik = itemView.findViewById(R.id.textViewBaslik)
            mHaberIcerik = itemView.findViewById(R.id.textViewIcerik)

            itemView.setOnClickListener {
                if (listener != null) {
                    val pos = adapterPosition

                    if (pos != RecyclerView.NO_POSITION)
                        listener.onItemClick(pos)
                }
            }
        }
    }

    override fun getItemCount() = habers.size

    override fun onBindViewHolder(holder: HaberViewHolder, position: Int)
    {
        val curItem = habers[position]

        holder.mImage.setImageResource(curItem.imageSrcId)
        holder.mHaberBaslik.text = curItem.Baslik
        holder.mHaberIcerik.text = curItem.author
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HaberViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item_view, parent, false)
        val bookViewHolder = HaberViewHolder(view, mListener)
        return bookViewHolder
    }
}