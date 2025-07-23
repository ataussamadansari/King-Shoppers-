package com.example.kingshoppers.ui.screens.navScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kingshoppers.navGraph.BottomNavigationBar
import com.example.kingshoppers.navGraph.graphs.MainNavGraph
import com.example.kingshoppers.utils.bottomNavigationItemsList

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    homeNavController: NavHostController = rememberNavController(),
    rootNavController: NavHostController
) {
    val context = LocalContext.current.applicationContext
    val navBackStackEntry by homeNavController.currentBackStackEntryAsState()
    val currentRoute by remember(navBackStackEntry) {
        derivedStateOf {
            navBackStackEntry?.destination?.route
        }
    }


    Scaffold(

        bottomBar = {
            BottomNavigationBar(
                items = bottomNavigationItemsList,
                currentRoute = currentRoute
            ) {currentNavigationItem ->
                homeNavController.navigate(currentNavigationItem.route) {
                    homeNavController.graph.startDestinationRoute?.let {startDestinationRoute->
                        popUpTo(startDestinationRoute) {
                            saveState = true
                        }

                        // Configure navigation to avoid multiple instances of the same destination
                        launchSingleTop = true

                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                }
            }
        }
    ) {innerPadding ->
        MainNavGraph(
            homeNavController = homeNavController,
            rootNavController = rootNavController,
            modifier = Modifier.padding(innerPadding),
        )
    }
}


