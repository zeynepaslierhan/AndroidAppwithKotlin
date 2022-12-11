package com.zeynepaslierhan.superherobooks

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var superHeros = ArrayList<String>()

        superHeros.add("Batman")
        superHeros.add("Superman")
        superHeros.add("Iron Man")

        var superHerosImgs = ArrayList<Bitmap>()

        val batmanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.Batman)
        val supermanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.Superman)
        val ironmanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ironman)

        superHerosImgs.add(batmanBitmap)
        superHerosImgs.add(supermanBitmap)
        superHerosImgs.add(ironmanBitmap)
    }
}