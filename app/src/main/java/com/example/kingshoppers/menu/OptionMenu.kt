package com.example.kingshoppers.menu

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.outlined.Adb
import androidx.compose.material.icons.outlined.HeadsetMic
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kingshoppers.navGraph.Screens
import com.example.kingshoppers.ui.theme.White

@Composable
fun OptionMenu(
    expanded: Boolean,
    onDismiss: () -> Unit,
    appNavController: NavController
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { onDismiss() },
        modifier = Modifier
            .background(White),
    ) {
        DropdownMenuItem(
            text = {
                Text(
                    "My Account", color = Color.Black
                )
            },
            onClick = {
                onDismiss()
                appNavController.navigate(Screens.MyAccount.screen)
            },
            leadingIcon = {
                Icon(
                    Icons.Outlined.Person,
                    contentDescription = null,
                    tint = Color.DarkGray
                )
            }
        )
        HorizontalDivider()
        DropdownMenuItem(
            text = { Text("Notifications", color = Color.Black) },
            onClick = {
                onDismiss()
            },
            leadingIcon = {
                Icon(
                    Icons.Outlined.Notifications,
                    contentDescription = null,
                    tint = Color.DarkGray
                )
            }
        )
        HorizontalDivider()
        DropdownMenuItem(
            text = { Text("My Orders", color = Color.Black) },
            onClick = {
                onDismiss()
            },
            leadingIcon = {
                Icon(
                    Icons.Outlined.ShoppingBag,
                    contentDescription = null,
                    tint = Color.DarkGray
                )
            }
        )
        HorizontalDivider()
        DropdownMenuItem(
            text = { Text("Contact Us", color = Color.Black) },
            onClick = {
                onDismiss()
            },
            leadingIcon = {
                Icon(
                    Icons.Outlined.HeadsetMic,
                    contentDescription = null,
                    tint = Color.DarkGray
                )
            }
        )
        HorizontalDivider()
        DropdownMenuItem(
            text = { Text("Privacy Policy", color = Color.Black) },
            onClick = {
                onDismiss()
            },
            leadingIcon = {
                Icon(
                    Icons.AutoMirrored.Filled.HelpOutline,
                    contentDescription = null,
                    tint = Color.DarkGray
                )
            }
        )
        HorizontalDivider()
        DropdownMenuItem(
            text = {
                Text(
                    "Version ${getAppVersion(LocalContext.current.applicationContext)}",
                    color = Color.Gray
                )
            },
            onClick = {
                onDismiss()
            },
            leadingIcon = {
                Icon(
                    Icons.Outlined.Adb,
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        )
    }
}

fun getAppVersion(context: Context): String {
    return try {
        val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
        packageInfo.versionName ?: "N/A"
    } catch (e: Exception) {
        "N/A"
    }
}

