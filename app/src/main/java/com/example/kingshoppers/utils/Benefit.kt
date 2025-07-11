package com.example.kingshoppers.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


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
            Text(
                text = title,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.W500
            )
            Text(text = description, fontSize = 14.sp, color = Color.Gray, lineHeight = 15.sp)
        }
    }
}