package com.example.kingshoppers.navGraph.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kingshoppers.navGraph.AuthRouteScreen
import com.example.kingshoppers.navGraph.Graph
import com.example.kingshoppers.navGraph.SplashRouteScreen
import com.example.kingshoppers.ui.screens.SplashScreen
import com.example.kingshoppers.ui.screens.auth.AuthScreen

fun NavGraphBuilder.splashNavGraph(
    rootNavController: NavHostController
) {
    navigation(
        route = Graph.SplashGraph,
        startDestination = SplashRouteScreen.Splash.route
    ) {
        composable(
            route = SplashRouteScreen.Splash.route
        ) {
            SplashScreen(navController = rootNavController)
        }
    }
}