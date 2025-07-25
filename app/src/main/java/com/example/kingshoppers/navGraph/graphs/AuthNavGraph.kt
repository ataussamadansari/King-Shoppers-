package com.example.kingshoppers.navGraph.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kingshoppers.navGraph.AuthRouteScreen
import com.example.kingshoppers.navGraph.Graph
import com.example.kingshoppers.ui.screens.auth.AuthScreen
import com.example.kingshoppers.ui.screens.auth.OtpScreen

fun NavGraphBuilder.authNavGraph(
    rootNavController: NavHostController
) {
    navigation(
        route = Graph.AuthGraph,
        startDestination = AuthRouteScreen.Login.route
    ) {
        composable(
            route = AuthRouteScreen.Login.route
        ) {
            AuthScreen(navController = rootNavController)
        }

        composable(route = AuthRouteScreen.Otp.route) { backStackEntry ->
            val phone = backStackEntry.arguments?.getString("phone") ?: ""
            OtpScreen(phone = phone, navController = rootNavController)
        }

    }
}