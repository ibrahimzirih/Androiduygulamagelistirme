package camera.app

import android.content.Context
import android.graphics.Bitmap
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class GridViewAdapter(
    private val context: Context,
    private val data: ArrayList<Bitmap>
): BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = View.inflate(context, R.layout.activity_image, null)
        view.findViewById<ImageView>(R.id.imageView).setImageBitmap(data[position])
        return view
    }
}