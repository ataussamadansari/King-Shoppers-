package com.example.kingshoppers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.kingshoppers.navGraph.AppNavGraph
import com.example.kingshoppers.ui.theme.KingShoppersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KingShoppersTheme {
                Surface(modifier = Modifier
                    .fillMaxSize()) {
                    val navController = rememberNavController()
                    AppNavGraph(navController = navController, this)
                }
            }
        }
    }
}
