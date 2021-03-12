package com.kaan.kotliniconicbuildings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.list_row.*
import kotlinx.android.synthetic.main.list_row.textView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val intent = intent
        val buildingName = intent.getStringExtra("name")
        textView.text = buildingName
        //val buildingImagesId = intent.getIntExtra("image", 0)

        /*
        val selectedBitmap = BitmapFactory.decodeResource(applicationContext.resources, buildingImagesId)
        ImageView.setImageBitmap(selectedBitmap)
        */

        val companion = Companion.Chosen
        val selectedBitmap = companion.selectedImage
        imageView.setImageBitmap(selectedBitmap)

    }

}