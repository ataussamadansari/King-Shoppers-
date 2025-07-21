package com.example.kingshoppers.ui.screens

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.kingshoppers.model.BannerItem
import com.example.kingshoppers.model.layouts.HomeSection
import com.example.kingshoppers.ui.screens.itemLayout.DealLayout
import com.example.kingshoppers.ui.screens.itemLayout.LootLayout
import com.example.kingshoppers.ui.screens.masterCategories.MasterCategoryItem
import com.example.kingshoppers.ui.theme.Purple40
import com.example.kingshoppers.ui.theme.White
import com.example.kingshoppers.utils.pager.BannerSlider
import com.example.kingshoppers.utils.update.AppUpdate
import com.example.kingshoppers.viewModel.HomeViewModel
import com.example.kingshoppers.viewModel.MasterCategoryViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    appNavController: NavController
) {
    val listState = rememberLazyListState()
    val isCollapsed by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0 || listState.firstVisibleItemScrollOffset > 50
        }
    }

    val viewModel: MasterCategoryViewModel = viewModel()
    val masterCategories by viewModel.masterCategories.collectAsState()
    val brands = viewModel.getBrands()
    val categories = viewModel.getCategories()

    val context = LocalContext.current.applicationContext

    val homeViewModel: HomeViewModel = viewModel()
    val sections by homeViewModel.sections.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple40)
    )
    {

        Column(
            modifier = modifier
                .fillMaxSize()
        ) {

            // TopBar
            AnimatedVisibility(visible = !isCollapsed) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                )
                {
                    Icon(
                        imageVector = Icons.Default.Storefront,
                        contentDescription = null,
                        tint = White
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Row {
                            Text(
                                text = "Shop Address", fontWeight = FontWeight.Bold,
                                color = White,
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null,
                                tint = White
                            )
                        }
                        Text(
                            text = "112234",
                            color = White,
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = White
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 12.dp),
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(width = 1.dp, shape = CircleShape, color = Color.Gray)
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = White
                    )
                    Text(
                        text = "Search Here...",
                        color = White,
                    )
                }
            }


            // Body Start
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .background(White),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                item {
                    AppUpdate(true)
                }

                // 2 items per row manually
                items(masterCategories.chunked(2)) { rowItems ->
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        for (item in rowItems) {
                            Box(modifier = Modifier.weight(1f)) {
                                MasterCategoryItem(item) {
                                    Toast.makeText(
                                        context,
                                        "Click: ${item.title}",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                        if (rowItems.size < 2) {
                            Spacer(modifier = Modifier.weight(1f)) // Fill the empty space
                        }
                    }
                }


                val banners = listOf(
                    BannerItem(
                        "https://img.freepik.com/free-vector/cartoon-style-eco-cleaning-background_52683-79729.jpg",
                        type = "product",
                        id = "1"
                    ),
                    BannerItem(
                        "https://img.freepik.com/free-photo/toilet-bag-products-arrangement_23-2149879995.jpg",
                        type = "category",
                        id = "cat1"
                    ),
                    BannerItem(
                        "https://img.freepik.com/free-vector/realistic-peanut-butter-horizontal-advertising-with-branded-product-editable-text-arachis-bean-images_1284-29379.jpg",
                        type = "category",
                        id = "cat1"
                    )
                )


                // 3 Pager
                item {
//                    HorizontalPagerSample()
                    BannerSlider(bannerItems = banners) { clickedBanner ->

                    }
                }

                // 4
                items(sections) { section ->
                    when (section) {
                        is HomeSection.LootSection -> LootLayout(section)
                        is HomeSection.DealSection -> DealLayout(section)
                    }
                }

            }
        }
    }
}


