package com.legendarysz.tripify.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.legendarysz.tripify.Domains.PopularDomain
import com.legendarysz.tripify.R

class DetailsActivity : AppCompatActivity() {

    private lateinit var tvTitle: TextView
    private lateinit var tvLocation: TextView
    private lateinit var tvBed: TextView
    private lateinit var tvGuide: TextView
    private lateinit var tvWifi: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvScore: TextView
    private lateinit var tvPrice: TextView
    private lateinit var item: PopularDomain
    private lateinit var picImg: ImageView
    private lateinit var ivBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initView()
        setVariable()
    }

    private fun setVariable() {
        item = intent.getSerializableExtra("object") as PopularDomain

        tvTitle.text = item.title
        tvScore.text = item.score.toString()
        tvLocation.text = item.location
        tvBed.text = item.bed.toString()+" Beds"
        tvDescription.text = item.description
        tvPrice.text = "$"+item.price.toString()

        if(item.guide){
            tvGuide.text = "Guide"
        }else{
            tvGuide.text = "NoGuide"
        }

        if(item.wifi){
            tvWifi.text = "Wifi"
        }else{
            tvWifi.text = "NoWifi"
        }


        val drawableResourceId = resources.getIdentifier(item.pic, "drawable", packageName)

        Glide.with(this)
            .load(drawableResourceId)
            .into(picImg)

        ivBack.setOnClickListener { finish() }

    }

    private fun initView() {
        tvTitle = findViewById(R.id.tvTitle)
        tvLocation = findViewById(R.id.tvLocation)
        tvBed = findViewById(R.id.tvBed)
        tvGuide = findViewById(R.id.tvGuide)
        tvPrice = findViewById(R.id.tvPrice)
        tvWifi = findViewById(R.id.tvWifi)
        tvDescription = findViewById(R.id.tvDescription)
        tvScore = findViewById(R.id.tvScore)
        picImg = findViewById(R.id.picImg2)
        ivBack = findViewById(R.id.ivBack)
    }
}