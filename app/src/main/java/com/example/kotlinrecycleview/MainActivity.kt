package com.example.kotlinrecycleview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var datalist: ArrayList<DataClass>
    lateinit var imageList: Array<Int>
    lateinit var textList: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        imageList= arrayOf(
            R.drawable.coat,
            R.drawable.jeans,
            R.drawable.pants,
            R.drawable.shirt,
            R.drawable.shoes,
            R.drawable.sweater,
            R.drawable.t_shirt

        )
        textList= arrayOf(
            "Coat",
            "Jeans","Pants","Shirt","Shoes","Sweater","T-Shirt"
        )
        recyclerView=findViewById(R.id.recycleView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        datalist= arrayListOf<DataClass>()
getData()
    }

    private fun getData(){
        for (i in imageList.indices) {
            val dataClass = DataClass(imageList[i], textList[i])
            datalist.add(dataClass)
        }
        recyclerView.adapter=AdapterClass(datalist)
    }
}
