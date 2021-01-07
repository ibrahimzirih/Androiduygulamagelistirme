package camera.app

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

/**
 * @author Abdulbaki Zırıh
 */

class MainActivity : AppCompatActivity() {
    private lateinit var info: TextView
    private lateinit var openCameraButton: Button
    private lateinit var gridView: GridView
    private lateinit var adapter: GridViewAdapter
    private val REQUEST_IMAGE_CAPTURE = 1
    private val CAMERA_REQUEST_CODE = 1000
    private val images = arrayListOf<Bitmap>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selection()
        appInit()
    }

    private fun selection() {
        info = findViewById(R.id.info)
        openCameraButton = findViewById(R.id.openCamera)
        gridView = findViewById(R.id.gridView)
    }

    private fun appInit() {
        if (!checkCameraHardware()) {
            info.text = "Cihazda kamera algılanmadı!"
            info.setTextColor(Color.RED)
        } else {
            info.text = "Cihaz kamerası algılandı!"
            info.setTextColor(Color.GREEN)
            openCameraButton.visibility = Button.VISIBLE
            openCameraButton.setOnClickListener {
                if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
                } else {
                    dispatchTakePictureIntent()
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    dispatchTakePictureIntent()
                } else {
                    Toast.makeText(this, "Kamera izni olmadan kamera açılamaz.", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "Bir sorun oluştu!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            images.add(imageBitmap)
            gridView.adapter = GridViewAdapter(this, images)
        }
    }

    private fun checkCameraHardware(): Boolean {
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA))
            return true
        return false
    }
}