package com.legendarysz.tripify.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.legendarysz.tripify.Domains.CategoryDomain
import com.legendarysz.tripify.R

//CategoryAdapter
class CategoryAdapter(private val context: Context, private val categoryList: List<CategoryDomain>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    // ViewHolder class
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleText)
        val picImg: ImageView = itemView.findViewById(R.id.CatImg)
    }

    // Inflate the layout when creating the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_category, parent, false)
        return ViewHolder(inflate)
    }

    // Bind the data to the ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoryList[position]

        holder.titleTextView.text = category.title

        val drawableResourceId = holder.itemView.resources.getIdentifier(category.picPath, "drawable", holder.itemView.context.packageName)

        // Using Glide to load the image (ensure you have the necessary dependency)
        Glide.with(context)
            .load(drawableResourceId)
            .into(holder.picImg)
    }

    // Return the size of the dataset
    override fun getItemCount(): Int = categoryList.size
}