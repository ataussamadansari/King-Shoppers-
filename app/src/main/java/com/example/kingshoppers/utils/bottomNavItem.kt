package com.example.kingshoppers.utils


import com.example.kingshoppers.R
import com.example.kingshoppers.navGraph.MainScreenRoute
import com.example.kingshoppers.navGraph.NavigationItem

val bottomNavigationItemsList = listOf(
    NavigationItem(
        title = "Home",
        route = MainScreenRoute.Home.route,
        selectedIcon = R.drawable.ic_home,
        unSelectedIcon = R.drawable.ic_home,
    ),
    NavigationItem(
        title = "Orders",
        route = MainScreenRoute.Order.route,
        selectedIcon = R.drawable.ic_orders,
        unSelectedIcon = R.drawable.ic_orders,
    ),
    NavigationItem(
        title = "Offers",
        route = MainScreenRoute.Offers.route,
        selectedIcon = R.drawable.ic_offers,
        unSelectedIcon = R.drawable.ic_offers,
    ),
    NavigationItem(
        title = "Cart",
        route = MainScreenRoute.Cart.route,
        selectedIcon = R.drawable.ic_shopping_bag,
        unSelectedIcon = R.drawable.ic_shopping_bag,
    ),
)