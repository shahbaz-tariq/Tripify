package com.legendarysz.tripify.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.legendarysz.tripify.Adapters.CategoryAdapter
import com.legendarysz.tripify.Adapters.PopularAdapter
import com.legendarysz.tripify.Domains.CategoryDomain
import com.legendarysz.tripify.Domains.PopularDomain
import com.legendarysz.tripify.R

//MainActivity.kt
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Dummy data for CategoryAdapter
        val categoryList = listOf(
            CategoryDomain("Beaches", "cat1"),
            CategoryDomain("Camps", "cat2"),
            CategoryDomain("Forests", "cat3"),
            CategoryDomain("Deserts", "cat4"),
            CategoryDomain("Mountains", "cat5"),
        )

        val categoryRecyclerView: RecyclerView = findViewById(R.id.view_cat)
        val categoryAdapter = CategoryAdapter(this, categoryList)
        categoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView.adapter = categoryAdapter

        // Dummy data for PopularAdapter
        val popularList = listOf(
            PopularDomain("Mar Caible, Avendia Lago", "Miami Beach", "This 2 bed / 1 bath home boasts an enormous,living plan, accented by striking architectural features and high-end finsihes.", 2, true, 4.5, "pic1", true, 1000),
            PopularDomain("Passo Rolle, TN", "Hawaii Beach", "Feel inspired by open sight lines that embrace the ourdoors, crowned by stunning coffered ceilings.", 3, false, 4.8, "pic2", false, 1500),
            PopularDomain("Lal Qila", "France", "This 2 bed / 1 bath home boasts an enormous,living plan, accented by striking architectural features and high-end finsihes.Feel inspired by open sight lines that embrace the ourdoors, crowned by stunning coffered ceilings.", 1, true, 5.0, "pic3", true, 1200)
        )

        val popularRecyclerView: RecyclerView = findViewById(R.id.view_pop)
        val popularAdapter = PopularAdapter(this, popularList)
        popularRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        popularRecyclerView.adapter = popularAdapter
    }
}