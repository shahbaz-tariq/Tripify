package com.legendarysz.tripify.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
            PopularDomain("Popular Item 1", "Miami Beach", "Description 1", 2, true, 4.5, "pic1", true, 100),
            PopularDomain("Popular Item 2", "Hawaii Beach", "Description 2", 3, false, 4.8, "pic2", false, 150),
            PopularDomain("Popular Item 3", "France", "Description 3", 1, true, 5.0, "pic3", true, 120)
        )

        val popularRecyclerView: RecyclerView = findViewById(R.id.view_pop)
        val popularAdapter = PopularAdapter(this, popularList)
        popularRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        popularRecyclerView.adapter = popularAdapter
    }
}