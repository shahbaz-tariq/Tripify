package com.legendarysz.tripify.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import com.legendarysz.tripify.Domains.PopularDomain
import com.legendarysz.tripify.R
import java.text.DecimalFormat

//PopularAdapter
class PopularAdapter(private val context: Context, private val popularList: List<PopularDomain>) :
    RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    private val formatter: DecimalFormat = DecimalFormat("###,###,###,###")

    // ViewHolder class
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTxt: TextView = itemView.findViewById(R.id.titleTxt)
        val locationTxt: TextView = itemView.findViewById(R.id.locationTxt)
        val scoreTxt: TextView = itemView.findViewById(R.id.scoreTxt)
        val picImg: ImageView = itemView.findViewById(R.id.picImg)
    }

    // Inflate the layout when creating the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_popular, parent, false)
        return ViewHolder(inflate)
    }

    // Bind the data to the ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val popularItem = popularList[position]

        holder.titleTxt.text = popularItem.title
        holder.locationTxt.text = popularItem.location
        holder.scoreTxt.text = popularItem.score.toString()

        val drawableResourceId = holder.itemView.resources.getIdentifier(popularItem.pic, "drawable", holder.itemView.context.packageName)

        // Load the image using Glide (ensure you have the necessary dependency)
        Glide.with(context)
            .load(drawableResourceId)
            .transform(CenterCrop(),GranularRoundedCorners(40F,40F,40F,40F))
            .into(holder.picImg)
    }

    // Return the size of the dataset
    override fun getItemCount(): Int = popularList.size
}
