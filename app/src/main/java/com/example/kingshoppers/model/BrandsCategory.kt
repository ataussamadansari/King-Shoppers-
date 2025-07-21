package com.example.kingshoppers.model

data class BrandsCategory(
    val title: String,
    val image: Int,
    val otherBrandsCategories: List<OtherBrandsCategory> = emptyList(),
    val product: List<ProductItem>
)
