package com.example.kingshoppers.ui.screens.productItemLayout

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.kingshoppers.model.ProductItem
import com.example.kingshoppers.ui.theme.Green
import com.example.kingshoppers.ui.theme.White

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductItem(product: ProductItem) {
    Log.d("ProductImage", "image: ${product.image}")

    Box(
        modifier = Modifier
            .width(180.dp)
            .fillMaxHeight()
            .padding(horizontal = 8.dp)
    ) {

        Card(
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(White),
            border = BorderStroke(width = 0.25.dp, color = Color(0x80A1A1A1))
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize(),
            ) {
                GlideImage(
                    model = product.image,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                )
                Text(
                    text = product.name,
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 18.sp,
                    ),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxSize(),
                )

                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        buildAnnotatedString {
                            append("MRP ₹")
                            withStyle(
                                style = SpanStyle(
                                    textDecoration = TextDecoration.LineThrough
                                )
                            ) {
                                append("500.00")
                            }
                        },
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )

//                    Text(text = "MRP ₹500.00", color = Color.Gray, fontSize = 11.sp)
                    Text(
                        text = "18.0%",
                        color = Green,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "₹500.00",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.height(35.dp)
                    ) {
                        Text(text = "Add")
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))
            }
        }

        val labelPer = product.labelPercentage ?: ""
        if (!labelPer.isBlank()) {
            VerticalDiscountBadge(discountPercent = labelPer)
        }

    }
}

@Composable
fun VerticalDiscountBadge(
    discountPercent: String = "1%",
    backgroundColor: Color = Color.Red,
    textColor: Color = Color.White,
    modifier: Modifier = Modifier
        .width(40.dp)
        .wrapContentHeight()
        .padding(start = 12.dp)
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Text Section
        Box(
            modifier = Modifier
                .background(backgroundColor)
                .fillMaxWidth()
                .padding(2.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = discountPercent + "\nOFF",
                    color = textColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 8.sp,
                    style = TextStyle(
                        lineHeight = 10.sp,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

            }
        }

        // Triangle Bottom Arrow using Canvas
        Canvas(
            modifier = Modifier
                .width(40.dp)
                .height(10.dp)
        ) {
            /* val path = Path().apply {
                 moveTo(0f, 0f)
                 lineTo(size.width / 2, size.height)
                 lineTo(size.width, 0f)
                 close()
             }*/
            val path = Path().apply {
                moveTo(0f, 0f) // Start from top-left

                // Number of zig-zag peaks
                val zigZagCount = 4
                val zigZagWidth = size.width / (zigZagCount * 2)
                val zigZagHeight = size.height / 2

                // Draw zig-zag pattern
                for (i in 0 until zigZagCount * 2) {
                    val x = i * zigZagWidth
                    val y = if (i % 2 == 0) 0f else zigZagHeight
                    lineTo(x, y)
                }

                lineTo(size.width, 0f) // End at top-right
                close() // Close the path
            }

            drawPath(path = path, color = backgroundColor)
        }
    }
}
