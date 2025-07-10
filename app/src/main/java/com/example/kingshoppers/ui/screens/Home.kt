package com.example.kingshoppers.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kingshoppers.R
import com.example.kingshoppers.ui.theme.Purple40
import com.example.kingshoppers.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current.applicationContext
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    /*Text(text = stringResource(R.string.app_name))*/
                    Image(
                        painter = painterResource(
                            R.drawable.title_logo_1
                        ),
                        contentDescription = "app logo",
                    )
                },
                actions = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Menu", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "MoreVert")
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
                .fillMaxSize()
                .padding(paddingValues)
                .background(Purple40)
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

            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .padding(
                        top = 16.dp,
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 100.dp
                    )
            ) {
                Heading("Introducing KingShoppers By XYZ", 20)

                Text(
                    text = "Watch the video to know more about your one stop wholesaler's destination",
                    color = Color.White,
                    fontSize = 14.sp,
                    lineHeight = 14.sp,
                    letterSpacing = 0.5.sp,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.height(16.dp))

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

                Spacer(modifier = Modifier.height(16.dp))

                Heading("Enjoy Super benefits Like", 24)

                Spacer(modifier = Modifier.height(16.dp))

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
                            R.drawable.avtar10,
                            "Super Earnings",
                            "Choose products that are popular in your locality & have higher earning potential."
                        )
                        BenefitsView(
                            R.drawable.e_commerce,
                            "Super Flexibility",
                            "Now you can choose What you buy, How much you buy, and When you buy."
                        )
                        BenefitsView(
                            R.drawable.avtar8,
                            "Super Service",
                            "At your Doorstep, 24hr delivery, safe credit facility & quick returns."
                        )
                    }
                }

                Image(painter = painterResource(R.drawable.avtar_girl), contentDescription = "avtar",
                    modifier = Modifier.scale(1.3f)
                        .fillMaxSize()
                        .align(Alignment.CenterHorizontally))

                Spacer(modifier = Modifier.height(16.dp))

                Heading("Top Brands", 24)

                Spacer(modifier = Modifier.height(16.dp))

            }
        }
    }
}

@Composable
fun Heading(text: String, fontSize: Int) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        color = White,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun BenefitsView(image: Int, title: String, description: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = image), contentDescription = title,
            modifier = Modifier.size(75.dp)
        )
        Column {
            Text(text = title, fontSize = 18.sp, color = Color.Black, fontWeight = FontWeight.W500)
            Text(text = description, fontSize = 14.sp, color = Color.Gray, lineHeight = 15.sp)
        }
    }
}