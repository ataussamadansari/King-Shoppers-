package com.example.kingshoppers.menu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DropdownMenuItem
import com.example.kingshoppers.model.Category
import com.example.kingshoppers.model.DropdownItem

fun MenuList(): List<DropdownItem> {

    return listOf(
        DropdownItem(Icons.Default.Home, "Home"),
        DropdownItem(Icons.Default.Person, "Person"),
        DropdownItem(Icons.Default.ShoppingCart, "Cart"),
        DropdownItem(Icons.Default.Settings, "Settings"),
        DropdownItem(Icons.Default.Call, "Calls"),
        DropdownItem(Icons.Default.Email, "Emails")
    )
}