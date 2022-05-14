package com.example.takescreenshot

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        val activityView: View = window.decorView.rootView
        val constraintLayout: ConstraintLayout = findViewById(R.id.container)
        val btnTakeScree: MaterialButton = findViewById(R.id.btnGetScreen)
        val imageView: AppCompatImageView = findViewById(R.id.imageView)
        btnTakeScree.setOnClickListener {
            val bitmap: Bitmap? = getScreenShot(activityView)

            if (bitmap != null) {
                imageView.setImageBitmap(bitmap)
            }
        }
    }

    private fun getScreenShot(view: View): Bitmap? {
        val returnBitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(returnBitmap)
        val bgDrawable = view.background
        if (bgDrawable != null)
            bgDrawable.draw(canvas)
        else canvas.drawColor(Color.WHITE)
        view.draw(canvas)
        return returnBitmap
    }
}