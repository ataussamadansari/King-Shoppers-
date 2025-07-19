package com.example.kingshoppers.model

import androidx.annotation.DrawableRes

data class MasterCategory(
    val title: String,
    @DrawableRes val image: Int,
    val brandsCategory: List<BrandsCategory> = emptyList(),
    val categories: List<Categories> = emptyList()
)
