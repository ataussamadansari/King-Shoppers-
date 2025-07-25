package com.example.kingshoppers.ui.screens.navScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kingshoppers.ui.theme.White

@Composable
fun OrderScreen(
    modifier: Modifier = Modifier,
    rootNavController: NavController
) {
    LazyColumn(
        modifier = Modifier
            .background(White)
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        item {
            Card(
                modifier = modifier
                    .height(1500.dp)
                    .fillMaxWidth()
            ) { }
        }
    }
}