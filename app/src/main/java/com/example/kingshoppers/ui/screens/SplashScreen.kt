package com.example.kingshoppers.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kingshoppers.R
import com.example.kingshoppers.navGraph.Graph
import com.example.kingshoppers.ui.theme.Purple40
import com.example.kingshoppers.ui.theme.White
import com.example.kingshoppers.viewModel.LoggedInViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@Composable
fun SplashScreen(navController: NavController, loggedInViewModel: LoggedInViewModel = hiltViewModel()) {
    val context = LocalContext.current

    val isLoggedIn = loggedInViewModel.isLoggedIn()

    LaunchedEffect(Unit) {
        delay(3000)
        if (isLoggedIn) {
            navController.navigate(Graph.MainScreenGraph) {
                popUpTo(Graph.SplashGraph) { inclusive = true }
            }
        } else {
            navController.navigate(Graph.AuthGraph) {
                popUpTo(Graph.SplashGraph) { inclusive = true }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Purple40)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.title_logo_2),
                contentDescription = "App Logo",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(150.dp)
                    .background(White)
                    .padding(12.dp)
            )

            Text(
                text = stringResource(R.string.app_name),
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}