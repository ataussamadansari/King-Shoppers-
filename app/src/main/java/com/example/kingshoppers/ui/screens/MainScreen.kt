package com.example.kingshoppers.ui.screens

import android.app.Activity
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kingshoppers.R
import com.example.kingshoppers.navGraph.BottomNavGraph
import com.example.kingshoppers.ui.theme.Purple40
import com.example.kingshoppers.ui.theme.Purple80
import com.example.kingshoppers.ui.theme.White

@Composable
fun MainScreen(navController: NavController, activity: Activity) {
    NavigationBarExample(appNavController = navController, activity = activity)
}

enum class Destination(
    val route: String,
    val label: String,
    val icon: Int,
    val contentDescription: String
) {
    Home("home", "Home", R.drawable.ic_home, "Home"),
    Brands("brands", "Brands", R.drawable.ic_brand, "Brands"),
    Wallet("wallet", "Wallet", R.drawable.ic_wallet, "Wallet"),
    Cart("cart", "Cart", R.drawable.ic_shopping_bag, "Cart"),
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationBarExample(
    modifier: Modifier = Modifier,
    appNavController: NavController,
    activity: Activity
) {
    val navController = rememberNavController()
    val startDestination = Destination.Home
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    val selectedIndex =
        Destination.entries.indexOfFirst { it.route == currentRoute }.coerceAtLeast(0)
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route
    val context = LocalContext.current.applicationContext

    Scaffold(
        modifier = modifier,
        bottomBar = {
            NavigationBar(
                windowInsets = NavigationBarDefaults.windowInsets,
                containerColor = White
            ) {
                Destination.entries.forEachIndexed { index, destination ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            Log.d(
                                "TAG",
                                "selectedIndex: $selectedIndex, currentRoute: $currentRoute, "
                            )
                            if (destination.route == "home") {
                                if (currentRoute == "home") {
                                    activity.finish()
                                } else {
                                    navController.navigate("home") {
                                        popUpTo("home") { inclusive = true }
                                    }
                                }
                            } else {
                                navController.navigate(destination.route) {
                                    popUpTo("home")
                                    launchSingleTop = true
                                }
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(destination.icon),
                                contentDescription = destination.contentDescription,
                            )
                        },
                        label = { Text(destination.label) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Purple40,
                            selectedTextColor = Purple40,
                            unselectedIconColor = Color.DarkGray,
                            unselectedTextColor = Color.DarkGray,
                            indicatorColor = Purple80
                        )
                    )
                }
            }
        }
    ) { contentPadding ->
        BottomNavGraph(
            navController = navController,
            appNavController = appNavController,
            startDestination,
            modifier = Modifier.padding(contentPadding)
        )
    }
}


