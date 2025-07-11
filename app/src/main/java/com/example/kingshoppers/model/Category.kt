package com.example.kingshoppers.model

import androidx.compose.ui.graphics.Color

data class Category(
    val id: String,
    val title: String,
    val items: List<SubCategory>,
    val catBgColorHex: String
) {
    fun bgColor(): Color {
        return try {
            Color(android.graphics.Color.parseColor(catBgColorHex))
        } catch (e: Exception) {
            Color.Gray // default fallback
        }
    }
}
