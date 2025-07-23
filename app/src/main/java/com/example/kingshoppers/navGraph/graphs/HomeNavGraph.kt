package com.example.kingshoppers.navGraph.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kingshoppers.navGraph.Graph
import com.example.kingshoppers.navGraph.HomeScreenRoute
import com.example.kingshoppers.ui.screens.profile.ProfileScreen

fun NavGraphBuilder.homeNavGraph(
    rootNavController: NavHostController
) {
    navigation(
        route = Graph.HomeGraph,
        startDestination = HomeScreenRoute.ProfileScreen.route
    ) {
        composable(route = HomeScreenRoute.ProfileScreen.route) {
            ProfileScreen(rootNavController = rootNavController)
        }
    }
}