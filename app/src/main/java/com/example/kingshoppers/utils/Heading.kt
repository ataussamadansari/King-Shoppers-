package com.example.kingshoppers.utils

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.kingshoppers.ui.theme.White

@Composable
fun Heading(text: String, fontSize: Int, color: Color = White, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        color = color,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier
    )
}