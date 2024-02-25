package com.legendarysz.tripify.Domains

import java.io.Serializable

data class ItemsDomain(
    val title: String,
    val location: String,
    val description: String,
    val bed: Int,
    val guide: Boolean,
    val score: Double,
    val pic: String,
    val wifi: Boolean,
    val price: Int
) : Serializable