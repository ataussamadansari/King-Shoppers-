package com.example.kingshoppers.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kingshoppers.R
import com.example.kingshoppers.model.auth.SendOtpRequest
import com.example.kingshoppers.navGraph.AuthRouteScreen
import com.example.kingshoppers.ui.theme.Purple40
import com.example.kingshoppers.viewModel.AuthViewModel
import com.example.kingshoppers.viewModel.LoggedInViewModel

@Composable
fun AuthScreen(navController: NavController) {

    val viewModel = viewModel<AuthViewModel>()
//    val sendOtpResponse by viewModel.sendOtpLiveData.observeAsState()


    val loggedInViewModel = viewModel<LoggedInViewModel>()


    var mobileNumber by remember { mutableStateOf("") }
    var errorMobileNumber by remember { mutableStateOf(false) }

    var selectedCountryCode by remember { mutableStateOf("+91") }

    val isNumberValid = Regex("^[6-9]\\d{9}$").matches(mobileNumber)


    var inputStatus by remember { mutableStateOf(InputStatus.DEFAULT) }

    val borderColor = when (inputStatus) {
        InputStatus.DEFAULT -> Purple40
        InputStatus.ERROR -> Color.Red
        InputStatus.WARNING -> Color(0xFFFFA500) // Orange
        InputStatus.SUCCESS -> Color(0xFF4CAF50) // Green
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        topBg()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 100.dp)
        ) {

            OutlinedTextField(
                value = mobileNumber,
                onValueChange = {
                    mobileNumber = it
                    inputStatus = when {
                        it.isEmpty() -> InputStatus.DEFAULT
                        !Regex("^[6-9]\\d{9}$").matches(it) -> InputStatus.ERROR
                        it.startsWith("123") -> InputStatus.WARNING  // dummy example
                        else -> InputStatus.SUCCESS
                    }
                },
                isError = errorMobileNumber,
                label = { Text("Mobile Number") },
                leadingIcon = {
                    Icon(Icons.Default.Phone, contentDescription = null)
                },
                textStyle = TextStyle(
                    fontSize = 19.sp,
                ),
                placeholder = {
                    Text(text = "987543210", fontSize = 19.sp)
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = borderColor,
                    focusedBorderColor = borderColor,
                    unfocusedLabelColor = Color.Gray,
                    focusedLabelColor = Color.DarkGray,
                    focusedTextColor = Color.Black,
                    focusedPlaceholderColor = Color.Gray
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )

            Button(
                onClick = {
                    viewModel.sendOtp(sendOtpRequest = SendOtpRequest(phone = mobileNumber))
                },
                colors = ButtonDefaults.buttonColors(
                    disabledContentColor = Color.DarkGray,
                    disabledContainerColor = Color.LightGray,
                    containerColor = Purple40,
                    contentColor = Color.White
                ),
                enabled = isNumberValid,
                elevation = ButtonDefaults.buttonElevation(4.dp),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()

            ) {
                Text(text = "Continue", fontSize = 20.sp, modifier = Modifier.padding(6.dp))
            }

        }
    }

}



enum class InputStatus {
    DEFAULT, ERROR, WARNING, SUCCESS
}

@Composable
fun topBg() {

    Column {
        Image(
            modifier = Modifier.fillMaxWidth(),
            alpha = 0.3f,
            painter = painterResource(R.drawable.title_logo_2), contentDescription = null
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier.weight(1f),
                alpha = 0.2f,
                painter = painterResource(R.drawable.title_logo_2), contentDescription = null
            )
            Image(
                modifier = Modifier.weight(2f),
                alpha = 0.3f,
                painter = painterResource(R.drawable.title_logo_2), contentDescription = null
            )
        }


        Image(
            modifier = Modifier.fillMaxWidth(),
            alpha = 0.4f,
            painter = painterResource(R.drawable.title_logo_2), contentDescription = null
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier.weight(1f),
                alpha = 0.2f,
                painter = painterResource(R.drawable.title_logo_2), contentDescription = null
            )

            Image(
                painter = painterResource(R.drawable.king_shoppers),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp)
                    .border(2.dp, color = Color.DarkGray, shape = CircleShape),
            )

            Image(
                modifier = Modifier.weight(1f),
                alpha = 0.3f,
                painter = painterResource(R.drawable.title_logo_2), contentDescription = null
            )
        }


    }
}