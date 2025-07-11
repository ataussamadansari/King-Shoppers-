package com.example.kingshoppers.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kingshoppers.model.Category

@Composable
fun CategorySection(category: Category) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = category.title,
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            modifier = Modifier
        )

        LazyRow {
            items(category.items) { subCategory ->
                SubCategoryItem(subCategory = subCategory, category.bgColor())
            }
        }
    }
}
