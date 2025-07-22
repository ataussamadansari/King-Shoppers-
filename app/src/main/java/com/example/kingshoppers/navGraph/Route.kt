package com.example.kingshoppers.navGraph

object Graph {
    const val RootGraph = "rootGraph"
    const val SplashGraph = "splashGraph"
    const val AuthGraph = "authGraph"
    const val MainScreenGraph = "mainScreenGraph"
    const val HomeGraph = "homeGraph"
}

sealed class SplashRouteScreen(val route: String) {
    object Splash : SplashRouteScreen("splash")
}
sealed class AuthRouteScreen(val route: String) {
    object Login : AuthRouteScreen("login")
}

sealed class MainScreenRoute(val route: String) {
    object Home : MainScreenRoute("home")
    object Order : MainScreenRoute("order")
    object Offers : MainScreenRoute("offers")
    object Cart : MainScreenRoute("cart")
}

