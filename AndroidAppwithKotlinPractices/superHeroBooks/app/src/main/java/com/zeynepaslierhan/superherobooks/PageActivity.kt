package com.zeynepaslierhan.superherobooks

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_page.*

class PageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

        val intent = intent
        val chosenName = intent.getStringExtra("superHerosNames")
        textView.text =chosenName

        val chosen = SingletonClass.chosen
        val chosenImg= chosen.img

        imageView.setImageBitmap(chosenImg)


    }
}