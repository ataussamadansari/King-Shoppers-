package com.example.kingshoppers.ui.screens

import android.app.Activity
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kingshoppers.MainActivity
import com.example.kingshoppers.R
import com.example.kingshoppers.navGraph.AppNavGraph
import com.example.kingshoppers.navGraph.BottomNavGraph
import com.example.kingshoppers.navGraph.Screens
import com.example.kingshoppers.ui.theme.Purple40
import com.example.kingshoppers.ui.theme.Purple80
import com.example.kingshoppers.ui.theme.PurpleGrey40
import com.example.kingshoppers.ui.theme.PurpleGrey80
import com.example.kingshoppers.ui.theme.White

@Composable
fun MainScreen(activity: Activity) {
    /*val navController = rememberNavController()

    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar(
//                containerColor = GreenJC
            ) {
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navController.navigate(Screens.Home.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Purple40 else Color.DarkGray
                    )
                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Star
                        navController.navigate(Screens.Brands.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = "Brands",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Star) Purple40 else Color.DarkGray
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.MoreVert
                        navController.navigate(Screens.Wallet.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.MoreVert,
                        contentDescription = "Wallet",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.MoreVert) Purple40 else Color.DarkGray
                    )
                }
                Column(
//                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.ShoppingCart
                            navController.navigate(Screens.Cart.screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            Icons.Default.ShoppingCart,
                            contentDescription = "Cart",
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.ShoppingCart) Purple40 else Color.DarkGray
                        )
                    }
                    Text(text = "Cart")
                }
            }
        }
    ) { paddingValues ->
        BottomNavGraph(navController = navController, modifier = Modifier.padding(paddingValues))
    }*/

    NavigationBarExample(activity = activity)
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
    Cart("cart", "Cart", R.drawable.ic_shopping_bag, "Cart")
}


@Composable
fun NavigationBarExample(modifier: Modifier = Modifier, activity: Activity) {
    val navController = rememberNavController()
    val startDestination = Destination.Home
//    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    val selectedIndex = Destination.entries.indexOfFirst { it.route == currentRoute }.coerceAtLeast(0)

    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        modifier = modifier,
        bottomBar = {
            NavigationBar(windowInsets = NavigationBarDefaults.windowInsets,
                containerColor = White) {
                Destination.entries.forEachIndexed { index, destination ->
                    NavigationBarItem(
//                        selected = selectedDestination == index,
                        selected = selectedIndex == index,
                        onClick = {
                            /*if (destination.route == "home") {
                                if (currentDestination == "home") {
                                    activity.finish() // exit app
                                } else {
                                    navController.navigate("home") {
                                        popUpTo("home") { inclusive = true }
                                    }
                                    activity.finish() // optional: exit after home
                                }
                            } else {
                                navController.navigate(destination.route) {
                                    popUpTo("home") // Optional: to reset stack
                                    launchSingleTop = true
                                }
                                selectedDestination = index
                            }*/

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

                        /*onClick = {
                            navController.navigate(route = destination.route)
                            selectedDestination = index
                        },*/
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
        BottomNavGraph(navController, startDestination, modifier = Modifier.padding(contentPadding))
    }
}
