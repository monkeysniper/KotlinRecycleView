package com.example.kotlinrecycleview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var datalist: ArrayList<DataClass>
    private lateinit var adapterClass: AdapterClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        datalist = ArrayList()

        recyclerView = findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        datalist.apply {
            add(DataClass(R.drawable.coat, "Coat", "A warm winter coat"))
            add(DataClass(R.drawable.jeans, "Jeans", "Comfortable denim jeans"))
            add(DataClass(R.drawable.pants, "Pants", "Casual pants"))
            add(DataClass(R.drawable.shirt, "Shirt", "A nice formal shirt"))
            add(DataClass(R.drawable.shoes, "Shoes", "Stylish sneakers"))
            add(DataClass(R.drawable.sweater, "Sweater", "Soft wool sweater"))
            add(DataClass(R.drawable.t_shirt, "T-Shirt", "A casual t-shirt"))
        }

        adapterClass = AdapterClass(datalist) { item ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("title", item.dataTitle)
                putExtra("imageResId", item.dataImage)
                putExtra("description", item.dataDescription)
            }
            startActivity(intent)
        }


        recyclerView.adapter = adapterClass
    }
}
