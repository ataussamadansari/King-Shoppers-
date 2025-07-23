package com.example.kingshoppers.ui.screens.profile.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OptionItem(
    modifier: Modifier = Modifier,
    title: String?,
    optionTitle: String,
    icon: Int,
    isActive: Boolean = true,
    contentColor: Color,
    onClick: () -> Unit
) {

    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        title?.let {
            Text(text = it, color = Color.Gray, fontSize = 14.sp)
        }

        Button(
            onClick = onClick,
            enabled = isActive,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = contentColor,
                disabledContentColor = Color.LightGray,
                disabledContainerColor = Color.Transparent
            )
        ) {
            Icon(painter = painterResource(icon), contentDescription = optionTitle)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = optionTitle, modifier = Modifier.fillMaxWidth())
        }
    }
}
