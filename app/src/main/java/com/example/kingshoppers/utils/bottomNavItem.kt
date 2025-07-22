package com.example.kingshoppers.utils


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import com.example.kingshoppers.navGraph.MainScreenRoute
import com.example.kingshoppers.navGraph.NavigationItem

val bottomNavigationItemsList = listOf(
    NavigationItem(
        title = "Home",
        route = MainScreenRoute.Home.route,
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home,
    ),
    NavigationItem(
        title = "Profile",
        route = MainScreenRoute.Order.route,
        selectedIcon = Icons.Filled.Person,
        unSelectedIcon = Icons.Outlined.Person,
    ),
    NavigationItem(
        title = "Notification",
        route = MainScreenRoute.Offers.route,
        selectedIcon = Icons.Filled.Notifications,
        unSelectedIcon = Icons.Outlined.Notifications,
        badgeCount = 9
    ),
    NavigationItem(
        title = "Setting",
        route = MainScreenRoute.Cart.route,
        selectedIcon = Icons.Filled.Settings,
        unSelectedIcon = Icons.Outlined.Settings,
        hasBadgeDot = true
    ),
)