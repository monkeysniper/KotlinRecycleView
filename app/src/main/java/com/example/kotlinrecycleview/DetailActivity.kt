package com.example.kotlinrecycleview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("title")
        val imageResId = intent.getIntExtra("imageResId", -1)
        val description = intent.getStringExtra("description")

        findViewById<TextView>(R.id.titleTextView).text = title
        findViewById<ImageView>(R.id.imageView).setImageResource(imageResId)
        findViewById<TextView>(R.id.detailTextView).text = description
    }
}
