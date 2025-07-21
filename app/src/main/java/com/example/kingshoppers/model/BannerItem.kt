package com.example.kingshoppers.model

data class BannerItem(
    val imageUrl: String,
    val type: String, // "product" ya "category"
    val id: String    // productId ya categoryId, type ke basis par
)
