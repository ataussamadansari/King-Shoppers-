package com.example.kingshoppers.ui.screens.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.kingshoppers.ui.theme.Purple40

@Composable
fun AuthScreen(navController: NavController) {

    var mobileNumber by remember { mutableStateOf("") }
    var errorMobileNumber by remember { mutableStateOf(false) }

    var selectedCountryCode by remember { mutableStateOf("+91") }

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
                    AndroidView(
                        factory = { context ->
                            com.hbb20.CountryCodePicker(context).apply {
                                setOnCountryChangeListener {
                                    selectedCountryCode = selectedCountryCodeWithPlus
                                }
                            }
                        },
                        modifier = Modifier
                    )
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
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    disabledContentColor = Color.DarkGray,
                    disabledContainerColor = Color.LightGray,
                    containerColor = Purple40,
                    contentColor = Color.White
                ),
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
