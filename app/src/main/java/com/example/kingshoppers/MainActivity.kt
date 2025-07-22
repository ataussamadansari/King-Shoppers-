package com.example.kingshoppers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.kingshoppers.navGraph.graphs.RootNavGraph
import com.example.kingshoppers.ui.theme.KingShoppersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KingShoppersTheme {
                RootNavGraph()
            }
        }
    }
}
