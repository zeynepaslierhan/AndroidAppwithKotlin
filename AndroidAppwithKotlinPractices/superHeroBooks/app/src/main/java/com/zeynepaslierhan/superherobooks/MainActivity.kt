package com.zeynepaslierhan.superherobooks

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recycle_row.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var superHeros = ArrayList<String>()

        superHeros.add("Batman")
        superHeros.add("Superman")
        superHeros.add("Iron Man")

        var superHerosImgs = ArrayList<Bitmap>()

        val batmanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.batman)
        val supermanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.superman)
        val ironmanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ironman)

        superHerosImgs.add(batmanBitmap)
        superHerosImgs.add(supermanBitmap)
        superHerosImgs.add(ironmanBitmap)

        val layoutManager = LinearLayoutManager(this)
        textViewRecycler.layoutManager = layoutManager
        val adapter = RecyclerAdapter(superHeros,superHerosImgs)
        textViewRecycler.adapter = adapter
    }
}