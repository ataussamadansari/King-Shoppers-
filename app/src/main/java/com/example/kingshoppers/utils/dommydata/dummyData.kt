package com.example.kingshoppers.utils.dommydata

import com.example.kingshoppers.R
import com.example.kingshoppers.model.BrandsCategory
import com.example.kingshoppers.model.Categories
import com.example.kingshoppers.model.MasterCategory
import com.example.kingshoppers.model.OtherBrandsCategory
import com.example.kingshoppers.model.Product
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
                            Product(1, "Bajaj Almond Drops Oil", 85.0, "100ml", R.drawable.king_shoppers),
                            Product(2, "Bajaj Coconut Hair Oil", 60.0, "200ml", R.drawable.king_shoppers)
                        )
                    ),
                    OtherBrandsCategory(
                        title = "Personal Care",
                        image = R.drawable.king_shoppers,
                        product = listOf(
                            Product(3, "Bajaj Face Cream", 120.0, "50g", R.drawable.king_shoppers)
                        )
                    )
                ),
                product = listOf(
                    Product(4, "Bajaj Combo Pack", 199.0, "3 Items", R.drawable.king_shoppers)
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
                            Product(5, "Parle-G", 5.0, "100g", R.drawable.king_shoppers),
                            Product(6, "Monaco", 10.0, "75g", R.drawable.king_shoppers)
                        )
                    )
                ),
                product = listOf(
                    Product(7, "Parle Combo", 50.0, "5 Packs", R.drawable.king_shoppers)
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
                            Product(8, "Tea Cake", 40.0, "2 pcs", R.drawable.king_shoppers),
                            Product(9, "Khari", 25.0, "150g", R.drawable.king_shoppers)
                        )
                    ),
                    SubCategory(
                        title = "Chocolates",
                        image = R.drawable.king_shoppers,
                        product = listOf(
                            Product(10, "Choco Pie", 60.0, "6 pcs", R.drawable.king_shoppers)
                        )
                    )
                ),
                product = listOf(
                    Product(11, "Choco Combo", 99.0, "3 items", R.drawable.king_shoppers)
                )
            )
        )
    )
)
