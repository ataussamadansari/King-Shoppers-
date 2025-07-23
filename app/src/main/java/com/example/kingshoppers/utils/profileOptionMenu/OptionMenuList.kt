package com.example.kingshoppers.utils.profileOptionMenu

import android.widget.Toast
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.kingshoppers.R
import com.example.kingshoppers.model.profileOption.OptionSection
import com.example.kingshoppers.model.profileOption.ProfileOption
import com.example.kingshoppers.navGraph.AuthRouteScreen
import com.example.kingshoppers.navGraph.Graph
import com.example.kingshoppers.viewModel.LoggedInViewModel


@Composable
fun getProfileSections(
    onOptionClick: (String) -> Unit
): List<OptionSection> {
    val context = LocalContext.current.applicationContext

    return listOf(
        OptionSection(
            sectionTitle = "",
            options = listOf(
                ProfileOption(
                    "Contact Support",
                    R.drawable.ic_orders,
                    isActive = false
                ) { /* Disabled */ }
            )
        ),
        OptionSection(
            sectionTitle = "Refer and Earn",
            options = listOf(
                ProfileOption("Refer a Friend", R.drawable.ic_orders) {
                    Toast.makeText(context, "Refer clicked", Toast.LENGTH_SHORT).show()
                },
                ProfileOption("My Referrals", R.drawable.ic_orders) {
                    onOptionClick("My Referrals")
                }
            )
        ),
        OptionSection(
            sectionTitle = "Payment & Cards",
            options = listOf(
                ProfileOption("Saved Cards", R.drawable.ic_wallet) {
                    onOptionClick("Saved Cards")
                },
                ProfileOption("UPI & Wallets", R.drawable.ic_wallet) {

                }
            )
        ),
        OptionSection(
            options = listOf(
                ProfileOption("LogOut", R.drawable.ic_user_logout, Color.Red) {
                    onOptionClick("LogOut") // ✅ Trigger state from here
                }
            )
        )
    )
}

@Composable
fun LogoutDialog(rootNavController: NavController,
                 onDismiss: () -> Unit
) {
    val isLoggedInViewModel: LoggedInViewModel = hiltViewModel()

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Log Out?") },
        text = { Text("Are you sure you want to log out?") },
        confirmButton = {
            TextButton(onClick = {
                isLoggedInViewModel.clearToken()
                rootNavController.navigate(AuthRouteScreen.Login.route) {
                    popUpTo(Graph.MainScreenGraph) { inclusive = true }
                    launchSingleTop = true
                }
                onDismiss()
            }) {
                Text("Yes")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
