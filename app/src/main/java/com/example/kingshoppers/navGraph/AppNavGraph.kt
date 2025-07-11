package com.example.kingshoppers.navGraph

import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kingshoppers.ui.screens.BrandsScreen
import com.example.kingshoppers.ui.screens.CartScreen
import com.example.kingshoppers.ui.screens.Destination
import com.example.kingshoppers.ui.screens.HomeScreen
import com.example.kingshoppers.ui.screens.MainScreen
import com.example.kingshoppers.ui.screens.MyAccountScreen
import com.example.kingshoppers.ui.screens.SplashScreen
import com.example.kingshoppers.ui.screens.WalletScreen
import kotlinx.coroutines.withContext

@Composable
fun AppNavGraph(navController: NavHostController, activity: Activity) {

    NavHost(navController = navController, startDestination = "splash") {
        composable(Screens.Splash.screen) { SplashScreen(navController = navController) }
        composable(Screens.Main.screen) { MainScreen(navController = navController, activity = activity) }
        composable(Screens.MyAccount.screen) { MyAccountScreen(navController = navController) }
    }
}

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    appNavController: NavController,
    startDestination: Destination,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController,
        startDestination = startDestination.route
    ) {
        Destination.entries.forEach { destination ->
            composable(destination.route) {
                when (destination) {
                    Destination.Home -> HomeScreen(modifier = modifier, appNavController = appNavController)
                    Destination.Brands -> BrandsScreen(modifier = modifier)
                    Destination.Wallet -> WalletScreen(modifier = modifier)
                    Destination.Cart -> CartScreen(modifier = modifier)
                }
            }
        }
    }

    /*NavHost(navController = navController, startDestination = startDestination.route) {
        composable(Screens.Home.screen) { HomeScreen(modifier) }
        composable(Screens.Brands.screen) { BrandsScreen(modifier) }
        composable(Screens.Wallet.screen) { WalletScreen(modifier) }
        composable(Screens.Cart.screen) { CartScreen(modifier) }
    }*/
}