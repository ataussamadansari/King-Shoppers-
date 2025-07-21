package com.example.kingshoppers.model.layouts

import androidx.compose.ui.graphics.Color
import com.example.kingshoppers.model.ProductItem

sealed class HomeSection {
    data class LootSection(
        val title: String,
        val bgColor: Color,
        val gifUrl: String?,
        val items: List<ProductItem>
    ) : HomeSection()

    data class DealSection(
        val title: String,
        val items: List<ProductItem>
    ) : HomeSection()
}


data class LootItem(val title: String, val image: Int)
data class DealItem(val title: String, val discount: String)

data class HomeSectionWrapper(
    val type: String,
    val title: String,
    val bgColor: String? = null,
    val gifUrl: String? = null,
    val items: List<ProductItem>
)
