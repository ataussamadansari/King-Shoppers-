package com.example.kingshoppers.ui.screens.profile.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kingshoppers.ui.theme.Purple40
import com.example.kingshoppers.ui.theme.White

@Composable
fun ButtonItems(
    modifier: Modifier = Modifier,
    title: String,
    icon: Int,
    isActive: Boolean = true,
    onClick: () -> Unit,
) {

    OutlinedButton(
        onClick = onClick,
        enabled = isActive,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = White,
            contentColor = Purple40,
        ),
        border = if (isActive) BorderStroke(1.dp, color = Purple40) else BorderStroke(
            1.dp,
            color = Color.Gray
        ),
        modifier = modifier,
    ) {
        Icon(
            painter = painterResource(icon), contentDescription = title
        )
        Text(
            text = title, fontSize = 16.sp,
            modifier = Modifier.padding(4.dp)
        )
    }
}