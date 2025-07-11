package com.example.kingshoppers.utils.dommydata

import com.example.kingshoppers.R
import com.example.kingshoppers.model.Category
import com.example.kingshoppers.model.SubCategory

fun getDummyCategories(): List<Category> {
    return listOf(
        Category(
            id = "1",
            title = "SKIN",
            items = listOf(
                SubCategory("1", "Body Care", R.drawable.body_care),
                SubCategory("1", "Cream", R.drawable.body_care),
                SubCategory("1", "Cream", R.drawable.body_care),
                SubCategory("1", "Cream", R.drawable.body_care),
                SubCategory("1", "Cream", R.drawable.body_care),
                SubCategory("1", "Cream", R.drawable.body_care),
            ), "#D0BCFF"
        ),
        Category(
            id = "2",
            title = "MAKEUP",
            items = listOf(
                SubCategory("3", "Lipstick", R.drawable.body_care),
                SubCategory("3", "Lipstick", R.drawable.body_care),
                SubCategory("3", "Lipstick", R.drawable.body_care),
                SubCategory("3", "Lipstick", R.drawable.body_care),
                SubCategory("3", "Lipstick", R.drawable.body_care),
            ), "#EFB8C8"
        )
    )
}
