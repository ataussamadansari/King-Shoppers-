package com.example.kingshoppers.ui.screens.profile

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Api
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.kingshoppers.R
import com.example.kingshoppers.ui.screens.profile.items.ButtonItems
import com.example.kingshoppers.ui.theme.Purple40
import com.example.kingshoppers.ui.theme.Purple80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(modifier: Modifier = Modifier, rootNavController: NavController) {

    val context = LocalContext.current
    val isDarkTheme = isSystemInDarkTheme()

    LaunchedEffect(Unit) {
        // set the status bar icon color
        (context as ComponentActivity).enableEdgeToEdge(
            statusBarStyle = if (isDarkTheme) {
                SystemBarStyle.light(
                    scrim = android.graphics.Color.TRANSPARENT,
                    darkScrim = android.graphics.Color.TRANSPARENT
                )
            } else {
                SystemBarStyle.dark(
                    scrim = android.graphics.Color.TRANSPARENT
                )
            }
        )
    }

    val expandedAppBarHeight = 180.dp
    // header translation should be half of expandedAppBarHeight
    val headerTranslation = (expandedAppBarHeight / 2)

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val scrollState = scrollBehavior.state
    val appBarExpanded by remember {
        // app bar expanded state
        // collapsedFraction 1f = collapsed
        // collapsedFraction 0f = expanded
        derivedStateOf { scrollState.collapsedFraction < 0.9f }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(
                modifier = Modifier
                    .zIndex(0f)
                    .fillMaxWidth()
                    // the app bar background color
                    .background(Purple40)
            ) {
                CollapsedAppBar(rootNavController = rootNavController, visible = !appBarExpanded)
                TopAppBar(
                    title = {
                        AppBarHeader(
                            modifier = Modifier.graphicsLayer {
                                // set the header translationY based on the
                                // scroll behavior state collapsedFraction
                                translationY =
                                    scrollState.collapsedFraction * headerTranslation.toPx()
                            },
                            visible = appBarExpanded
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent,
                        scrolledContainerColor = Color.Transparent
                    ),
                    expandedHeight = expandedAppBarHeight,
                    // remove extra padding on top (from status bar)
                    windowInsets = WindowInsets(0),
                    scrollBehavior = scrollBehavior
                )
            }
        },
    ) { innerPadding ->
        val cornerRadius = 10.dp
        Box(
            modifier = Modifier
                .zIndex(1f)
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
                    .background(Purple40)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    // manually draw the elevation
                    .drawBehind {
                        val shadowColor = Color.Black.copy(alpha = 0.25f)
                        val paint = Paint().asFrameworkPaint().apply {
                            color = android.graphics.Color.TRANSPARENT
                            setShadowLayer(
                                4.dp.toPx(), // shadow blur
                                0f, // shadow offset x
                                (-1).dp.toPx(), // shadow offset y
                                shadowColor.toArgb() // shadow color
                            )
                        }

                        drawIntoCanvas {
                            it.nativeCanvas.drawRoundRect(
                                0f,
                                0f,
                                size.width,
                                size.height / 2,
                                cornerRadius.toPx(),
                                cornerRadius.toPx(),
                                paint
                            )
                        }
                    }
                    // background with rounded corner on top side
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(
                            topStart = cornerRadius,
                            topEnd = cornerRadius
                        )
                    )
            ) {

                ProfileBody(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                )
            }
        }
    }
}

@Composable
fun ButtonsGrid(
    modifier: Modifier = Modifier,
    onButtonClick: (String) -> Unit = {}
) {
    val buttonTitles = listOf("My Wallet", "Offers", "Vouchers", "My Rewards")
    val buttonIcons = listOf(
        R.drawable.ic_wallet, R.drawable.ic_offers,
        R.drawable.ic_brand, R.drawable.ic_reward
    )
    val disabledButtons = listOf("Vouchers") // Disable "Offers" button

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for (i in buttonTitles.indices step 2) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Left button
                ButtonItems(
                    modifier = Modifier.weight(1f),
                    title = buttonTitles[i],
                    icon = buttonIcons[i],
                    isActive = !disabledButtons.contains(buttonTitles[i]),
                    onClick = { onButtonClick(buttonTitles[i]) }
                )

                // Right button
                if (i + 1 < buttonTitles.size) {
                    ButtonItems(
                        modifier = Modifier.weight(1f),
                        title = buttonTitles[i + 1],
                        icon = buttonIcons[i + 1],
                        isActive = !disabledButtons.contains(buttonTitles[i + 1]),
                        onClick = { onButtonClick(buttonTitles[i + 1]) }
                    )
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}


@Composable
fun ProfileBody(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {

        item {
            ButtonsGrid(
                modifier = Modifier
                    .fillMaxWidth(),
                onButtonClick = { title ->
                    when (title) {
                        "My Wallet" -> { /* Navigate */
                        }

                        "Offers" -> { /* Show Offers */
                        }

                        "Vouchers" -> { /* Handle Vouchers */
                        }

                        "My Rewards" -> { /* Show Rewards */
                        }
                    }
                }
            )
        }


        item {
            Card(
                modifier = Modifier
                    .height(1000.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(Purple80)
            ) {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollapsedAppBar(
    modifier: Modifier = Modifier,
    rootNavController: NavController,
    visible: Boolean
) {
    TopAppBar(
        modifier = modifier,
        navigationIcon = {
            // back icon on the collapsed app bar
            IconButton(onClick = { rootNavController.popBackStack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        title = {
            // animate fadeIn fadeOut the avatar + name on the collapsed app bar
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(animationSpec = tween()),
                exit = fadeOut(animationSpec = tween())
            ) {
                // avatar + name on the collapsed app bar
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.surfaceDim,
                                shape = CircleShape
                            ),
                        painter = painterResource(R.drawable.avtar_girl),
                        contentDescription = null
                    )
                    Text(
                        text = "John Doe",
                        color = MaterialTheme.colorScheme.onTertiary,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            // set background color for expanded state to transparent
            containerColor = Color.Transparent,
            // set background color for collapsed state to transparent
            scrolledContainerColor = Color.Transparent,
            // set navigation icon color
            navigationIconContentColor = MaterialTheme.colorScheme.onTertiary
        )
    )
}

@Composable
fun AppBarHeader(
    modifier: Modifier = Modifier,
    visible: Boolean
) {
    // animate fadeIn fadeOut the expanded app bar header
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween()),
        exit = fadeOut(animationSpec = tween())
    ) {
        Column(
            // only add end padding
            // because the TopAppBar already has start padding
            modifier = modifier.padding(end = 16.dp, top = 4.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.surfaceDim,
                            shape = CircleShape
                        ),
                    painter = painterResource(R.drawable.avtar_girl),
                    contentDescription = null
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = "John Doe",
                        color = MaterialTheme.colorScheme.onTertiary,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "@johndoe",
                        color = MaterialTheme.colorScheme.onTertiary,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            Text(
                text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz",
                color = MaterialTheme.colorScheme.onTertiary,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}




