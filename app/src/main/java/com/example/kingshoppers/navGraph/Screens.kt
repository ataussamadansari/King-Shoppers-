package com.example.kingshoppers.navGraph

sealed class Screens(val screen: String) {
    data object Splash: Screens("splash")
    data object Main: Screens("main")
    data object Home: Screens("home")
    data object Brands: Screens("brands")
    data object Wallet: Screens("wallet")
    data object Cart: Screens("cart")
}