package com.example.kingshoppers.navGraph.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kingshoppers.navGraph.Graph
import com.example.kingshoppers.navGraph.MainScreenRoute
import com.example.kingshoppers.ui.screens.CartScreen
import com.example.kingshoppers.ui.screens.HomeScreen
import com.example.kingshoppers.ui.screens.OffersScreen
import com.example.kingshoppers.ui.screens.OrderScreen

@Composable
fun MainNavGraph(
    rootNavController: NavHostController,
    homeNavController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = homeNavController,
        route = Graph.MainScreenGraph,
        startDestination = MainScreenRoute.Home.route
    ) {
        composable(route = MainScreenRoute.Home.route) {
            HomeScreen(modifier = modifier, rootNavController = rootNavController)
        }
        composable(route = MainScreenRoute.Order.route) {
            OrderScreen(modifier = modifier, rootNavController = rootNavController)
        }
        composable(route = MainScreenRoute.Offers.route) {
            OffersScreen(modifier = modifier, rootNavController = rootNavController)
        }
        composable(route = MainScreenRoute.Cart.route) {
            CartScreen(modifier = modifier, rootNavController = rootNavController)
        }

    }
}