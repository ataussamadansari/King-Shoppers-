package com.example.kingshoppers.navGraph

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: Int,
    val unSelectedIcon: Int,
    val hasBadgeDot: Boolean = false,
    val badgeCount: Int? = null
)