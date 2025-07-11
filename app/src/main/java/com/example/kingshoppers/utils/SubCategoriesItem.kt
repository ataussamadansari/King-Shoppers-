package com.example.kingshoppers.utils

import androidx.annotation.Size
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kingshoppers.model.SubCategory

@Composable
fun SubCategoryItem(subCategory: SubCategory, bgColor: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(end = 8.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        val colorStops = arrayOf(
            0.0f to Color.White,
            0.3f to Color.White,
            1f to bgColor
        )

        Image(
            painter = painterResource(id = subCategory.imageRes),
            contentDescription = subCategory.title,
            modifier = Modifier
                .size(100.dp)
                .background(
                    brush = Brush.radialGradient(
                        colorStops = colorStops
                    ), shape = RoundedCornerShape(12.dp)
                )
                .padding(4.dp),
        )
        Spacer(modifier = modifier.height(4.dp))
        Text(
            text = subCategory.title,
            modifier = Modifier,
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}
