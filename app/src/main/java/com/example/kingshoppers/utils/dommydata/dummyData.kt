package com.example.kingshoppers.utils.dommydata

import com.example.kingshoppers.R
import com.example.kingshoppers.model.BrandsCategory
import com.example.kingshoppers.model.Categories
import com.example.kingshoppers.model.MasterCategory
import com.example.kingshoppers.model.OtherBrandsCategory
import com.example.kingshoppers.model.ProductItem
import com.example.kingshoppers.model.SubCategory

val dummyData = listOf(
    MasterCategory(
        title = "Brands",
        image = R.drawable.king_shoppers,
        brandsCategory = listOf(
            BrandsCategory(
                title = "Bajaj",
                image = R.drawable.king_shoppers,
                otherBrandsCategories = listOf(
                    OtherBrandsCategory(
                        title = "Hair Care",
                        image = R.drawable.king_shoppers,
                        product = listOf(
                        )
                    ),
                    OtherBrandsCategory(
                        title = "Personal Care",
                        image = R.drawable.king_shoppers,
                        product = listOf(
                        )
                    )
                ),
                product = listOf(
                )
            ),
            BrandsCategory(
                title = "Parle",
                image = R.drawable.king_shoppers,
                otherBrandsCategories = listOf(
                    OtherBrandsCategory(
                        title = "Biscuits",
                        image = R.drawable.king_shoppers,
                        product = listOf(
                        )
                    )
                ),
                product = listOf(
                )
            )
        )
    ),

    MasterCategory(
        title = "Categories",
        image = R.drawable.king_shoppers,
        categories = listOf(
            Categories(
                title = "Processed Food",
                subCategories = listOf(
                    SubCategory(
                        title = "Bakery",
                        image = R.drawable.king_shoppers,
                        product = listOf(
                        )
                    ),
                    SubCategory(
                        title = "Chocolates",
                        image = R.drawable.king_shoppers,
                        product = listOf(
                        )
                    )
                ),
                product = listOf(
                )
            )
        )
    )
)
