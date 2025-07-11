package com.example.kingshoppers.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kingshoppers.R
import com.example.kingshoppers.menu.OptionMenu
import com.example.kingshoppers.ui.theme.Purple40
import com.example.kingshoppers.ui.theme.White
import com.example.kingshoppers.utils.BenefitsView
import com.example.kingshoppers.utils.BrandsGrid
import com.example.kingshoppers.utils.CategorySection
import com.example.kingshoppers.utils.Heading
import com.example.kingshoppers.utils.dommydata.getDummyCategories

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, appNavController: NavController) {
    val context = LocalContext.current.applicationContext
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(
                            R.drawable.title_logo_1
                        ),
                        contentDescription = "app logo",
                    )
                },
                actions = {
                    Box(
//                        modifier = Modifier.padding(horizontal = 12.dp)
                    ) {
                        IconButton(onClick = { expanded = !expanded }) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "MoreVert")
                        }
                        OptionMenu(expanded = expanded, onDismiss = { expanded = false }, appNavController = appNavController)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    actionIconContentColor = Color.Black
                ),
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .background(White)
        ) {
            var searchText by remember { mutableStateOf("") }
            TextField(
                value = searchText,

                onValueChange = { searchText = it },

                modifier = Modifier
                    .background(White)
                    .padding(vertical = 4.dp, horizontal = 16.dp)
                    .height(48.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
                    .fillMaxWidth(),

                textStyle = TextStyle(
                    color = Color.Black,
                ),

                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                },
                placeholder = {
                    Text(
                        text = "Search for categories, Brands, Products, etc.",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        lineHeight = 1.sp
                    )
                },

                singleLine = true,

                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    cursorColor = Purple40,
                    errorCursorColor = Color.Red,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.Transparent,
                    unfocusedLabelColor = Color.Transparent
                )
            )

            LazyColumn(
                modifier = Modifier
                    .padding(bottom = 75.dp)
                ,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            )
            {
                item {
                    Column(
                        modifier = Modifier
                            .background(Purple40)
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    )
                    {
                        Column {
                            Heading("Introducing KingShoppers", 20)
                            Text(
                                text = "Watch the video to know more about your one stop wholesaler's destination",
                                color = Color.White,
                                fontSize = 14.sp,
                                lineHeight = 14.sp,
                                letterSpacing = 0.5.sp,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White)
                        ) {
                            // 👇 Use Box or Column to position content inside the Card
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp),
                                contentAlignment = Alignment.Center // or TopStart, BottomEnd, etc.
                            ) {
                                Text(
                                    text = "Video View",
                                    fontSize = 16.sp,
                                    color = Color.Black
                                )
                            }
                        }

                        Heading("Enjoy Super benefits Like", 24)

                        Card(
                            colors = CardDefaults.cardColors(containerColor = Color.White)
                        ) {
                            Column(modifier = Modifier.padding(8.dp)) {
                                BenefitsView(
                                    R.drawable.title_logo_2,
                                    "Your All-in-One Store",
                                    "Your favorite beauty and personal care brands, now get them all at KingShoppers."
                                )
                                BenefitsView(
                                    R.drawable.title_logo_2,
                                    "Super Earnings",
                                    "Choose products that are popular in your locality & have higher earning potential."
                                )
                                BenefitsView(
                                    R.drawable.title_logo_2,
                                    "Super Flexibility",
                                    "Now you can choose What you buy, How much you buy, and When you buy."
                                )
                                BenefitsView(
                                    R.drawable.title_logo_2,
                                    "Super Service",
                                    "At your Doorstep, 24hr delivery, safe credit facility & quick returns."
                                )
                            }
                        }

                        Image(
                            painter = painterResource(R.drawable.avtar_girl),
                            contentDescription = "avtar",
                            modifier = Modifier
                                .scale(1.5f)
                                .fillMaxSize()
                                .align(Alignment.CenterHorizontally)
                        )

                        Heading("Top Brands", 24)

                        val brandImages = listOf(
                            R.drawable.burger_king,
                            R.drawable.chanel,
                            R.drawable.coca_cola,
                            R.drawable.dell,
                            R.drawable.dove,
                            R.drawable.hp,
                            R.drawable.kfc,
                            R.drawable.lacost,
                            R.drawable.lenvo,
                            R.drawable.nestle,
                            R.drawable.nivea,
                            R.drawable.sony,
                            R.drawable.title_logo_2,
                            R.drawable.zara,
                        )

                        BrandsGrid(imageList = brandImages)

                        Image(
                            painter = painterResource(R.drawable.ic_shopping_avatar),
                            contentDescription = "shopping avtar",
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.CenterHorizontally)
                                .padding(12.dp)
                                .scale(1.2f),
                        )

                        Column {
                            Heading("Retailer Stories", 24)
                            Text(
                                text = "What customer say about us...",
                                fontSize = 14.sp,
                                color = Color.White,
                            )
                        }

                    }
                }

                item {
                    Heading(
                        "Recommended Categories",
                        22,
                        Color.Black,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

                val categories = getDummyCategories()

                // Categories List
                items(categories) { category ->
                    CategorySection(category = category)
                }

            }
        }
    }
}




