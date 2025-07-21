package com.example.kingshoppers.utils.update

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kingshoppers.ui.theme.White

@Composable
fun AppUpdate(isAvailable: Boolean) {

    if (isAvailable) {
        Row(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 12.dp)
                .fillMaxWidth()
                .background(Color(0xFF3FDC85), shape = RoundedCornerShape(12.dp))
                .padding(vertical = 4.dp, horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .background(Color(0x80F1F1F1), shape = RoundedCornerShape(12.dp))
                    .padding(4.dp)
            ) {
                Icon(imageVector = Icons.Default.Download, contentDescription = null, tint = White)
            }
            Text(
                text = "Download the new version of \nthe King Shoppers app",
                fontSize = 12.sp,
                color = White,
                lineHeight = 15.sp,
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Download")
            }
        }
    }
}