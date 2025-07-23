package com.example.kingshoppers.model.profileOption

import androidx.compose.ui.graphics.Color

data class ProfileOption(
    val title: String,
    val icon: Int,
    val contentColor: Color = Color.Gray,
    val isActive: Boolean = true,
    val onClick: () -> Unit
)