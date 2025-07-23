package com.example.kingshoppers.navGraph.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kingshoppers.navGraph.Graph
import com.example.kingshoppers.ui.screens.navScreen.MainScreen

@Composable
fun RootNavGraph() {
    val rootNavController = rememberNavController()

    NavHost(
        navController = rootNavController,
        route = Graph.RootGraph,
        startDestination = Graph.SplashGraph
    ) {
        splashNavGraph(rootNavController = rootNavController)
        authNavGraph(rootNavController = rootNavController)
        composable(route = Graph.MainScreenGraph) {
            MainScreen(rootNavController = rootNavController)
        }
        homeNavGraph(rootNavController = rootNavController)
    }
}