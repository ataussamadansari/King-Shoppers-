package com.example.kingshoppers.model

data class Categories(
    val title: String,
    val subCategories: List<SubCategory> = emptyList(),
    val product: List<ProductItem>
)
