package com.kaan.kotliniconicbuildings

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

//var selectedGlobalBitmap : Bitmap? = null

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Data
        var buildingNames = ArrayList<String>()
        buildingNames.add("Acropolis")
        buildingNames.add("Colosseum")
        buildingNames.add("Giza")
        buildingNames.add("Sultanahmet")


        //Image
        val acropolis = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.acropolis)
        val colosseum = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.colosseum)
        val giza = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.giza)
        val sultanahmet = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.sultanahmet)

        var buildingImages = ArrayList<Bitmap>()
        buildingImages.add(acropolis)
        buildingImages.add(colosseum)
        buildingImages.add(giza)
        buildingImages.add(sultanahmet)

/*
        //Image - Efficient
        val acropolisId = R.drawable.acropolis
        val colosseumId = R.drawable.colosseum
        val gizaId = R.drawable.giza
        val sultanahmetId = R.drawable.sultanahmet

        var buildingImagesId = ArrayList<Int>()
        buildingImagesId.add(acropolisId)
        buildingImagesId.add(colosseumId)
        buildingImagesId.add(gizaId)
        buildingImagesId.add(sultanahmetId)
 */

        //Adapter: Layout & Data

        //val adapter = ArrayAdapter(this, R.layout.list_row,R.id.textView2, buildingNames)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, buildingNames)

        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(applicationContext, DetailsActivity::class.java)

            intent.putExtra("name", buildingNames[position])

            //intent.putExtra("image", buildingImagesId[position])

            val companion = Companion.Chosen
            companion.selectedImage = buildingImages[position]

            startActivity(intent)
        }
    }
}