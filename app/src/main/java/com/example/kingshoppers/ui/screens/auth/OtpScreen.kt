package com.example.kingshoppers.ui.screens.auth

import android.os.CountDownTimer
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.kingshoppers.model.auth.VerifyOtpRequest
import com.example.kingshoppers.navGraph.Graph
import com.example.kingshoppers.ui.theme.Purple40
import com.example.kingshoppers.ui.theme.White
import com.example.kingshoppers.utils.LoadingScreen
import com.example.kingshoppers.utils.NetworkResult
import com.example.kingshoppers.viewModel.AuthViewModel
import com.example.kingshoppers.viewModel.LoggedInViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpScreen(
    phone: String,
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel(),
    loggedInViewModel: LoggedInViewModel = hiltViewModel()
) {

    val context = LocalContext.current.applicationContext
    val verifyOtpResponse by viewModel.verifyOtpLiveData.observeAsState()

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val scope = rememberCoroutineScope()

    val otpLength = 6
    val otpValues = remember { mutableStateListOf("", "", "", "", "", "") }

    var secondsRemaining by remember { mutableStateOf(30) }
    var canResend by remember { mutableStateOf(false) }

    // Show feedback
    var showMessage by remember { mutableStateOf<String?>(null) }

    // Timer
    LaunchedEffect(Unit) {
        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                secondsRemaining = (millisUntilFinished / 1000).toInt()
            }

            override fun onFinish() {
                canResend = true
            }
        }.start()
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "OTP Verification")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = White,
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.Black
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .padding(innerPadding)
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "we've sent a verification code to", color = Color.DarkGray)
            Text(text = phone, fontWeight = FontWeight.SemiBold, color = Color.Black)
            Spacer(modifier = Modifier.height(32.dp))


            /*Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                otpValues.forEachIndexed { index, value ->
                    OutlinedTextField(
                        value = value,
                        onValueChange = {
                            if (it.length <= 1 && it.all { char -> char.isDigit() }) {
                                otpValues[index] = it
                                if (it.isNotEmpty() && index < otpLength - 1) {
                                    focusManager.moveFocus(FocusDirection.Next)
                                }
                            }
                        },
                        textStyle = TextStyle(
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            color = Color.Black
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Purple40,
                            cursorColor = Color.Black,
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .width(56.dp)
                            .height(56.dp)
                            .align(Alignment.CenterVertically)
                            .onKeyEvent { event ->
                                if (event.nativeKeyEvent.keyCode == android.view.KeyEvent.KEYCODE_DEL &&
                                    event.nativeKeyEvent.action == android.view.KeyEvent.ACTION_DOWN
                                ) {
                                    if (value.isEmpty() && index > 0) {
                                        otpValues[index - 1] = ""
                                        focusManager.moveFocus(FocusDirection.Previous)
                                    }
                                }
                                false
                            }
                    )
                }
            }
*/


            // Inside composition, use this only for testing.
            // I recommend to do it through viewModel like above.
            val otpValues =
                remember { mutableStateListOf("", "", "", "", "", "") }

            OTPInputTextFields(
                otpValues = otpValues,
                otpLength = 6,
                onOtpInputComplete = { /* TODO: Make api calls or anything after validation */ },
                onUpdateOtpValuesByIndex = { index, value ->
                    otpValues[index] = value
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Resend OTP
            TextButton(
                onClick = {
                    if (canResend) {
                        // TODO: Implement resend logic
                        canResend = false
                        secondsRemaining = 30
                        object : CountDownTimer(30000, 1000) {
                            override fun onTick(millisUntilFinished: Long) {
                                secondsRemaining = (millisUntilFinished / 1000).toInt()
                            }

                            override fun onFinish() {
                                canResend = true
                            }
                        }.start()
                    }
                },
                enabled = canResend
            ) {
                Text(
                    text = if (canResend) "Resend OTP" else "Resend in $secondsRemaining s",
                    color = if (canResend) Purple40 else Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Verify Button
            Button(
                onClick = {
                    val enteredOtp = otpValues.joinToString("")
                    if (enteredOtp.length < 6) {
                        showMessage = "Please enter a valid 6-digit OTP"
                        Toast.makeText(context, showMessage, Toast.LENGTH_SHORT).show()
                        return@Button
                    }
                    keyboardController?.hide()
                    viewModel.verifyOtp(
                        verifyOtpRequest = VerifyOtpRequest(
                            phone = phone,
                            otp = enteredOtp
                        )
                    )
                },
                enabled = otpValues.all { it.isNotEmpty() },
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
                Text(text = "Verify", fontSize = 20.sp, modifier = Modifier.padding(6.dp))
            }

        }

        verifyOtpResponse?.let { result ->
            when (result) {
                is NetworkResult.Success -> {
                    val token = result.data?.results?.token
                    token?.let {
                        loggedInViewModel.saveToken(it)
                        Log.d("OtpScreenTAG", "Token saved: $it")

                        navController.navigate(Graph.MainScreenGraph) {
                            popUpTo(Graph.AuthGraph) { inclusive = true }
                            launchSingleTop = true
                        }
                    }

                }

                is NetworkResult.Error -> {
                    Log.d("OtpScreenTAG", "message: ${result.message}")
                    Toast.makeText(context, "${result.message}", Toast.LENGTH_SHORT).show()
                }

                is NetworkResult.Loading -> {
                    LoadingScreen()
                }
            }
        }
    }
}

@Composable
fun OTPInputTextFields(
    otpLength: Int,
    onUpdateOtpValuesByIndex: (Int, String) -> Unit,
    onOtpInputComplete: () -> Unit,
    modifier: Modifier = Modifier,
    otpValues: List<String> = List(otpLength) { "" }, // Pass this as default for future reference
    isError: Boolean = false,
) {
    val focusRequesters = List(otpLength) { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
//        horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally)
    ) {
        otpValues.forEachIndexed { index, value ->
            OutlinedTextField(
                modifier = Modifier
                    .weight(1f)
//                    .width(64.dp)
                    .padding(6.dp)
                    .focusRequester(focusRequesters[index])
                    .onKeyEvent { keyEvent ->
                        if (keyEvent.key == Key.Backspace) {
                            if (otpValues[index].isEmpty() && index > 0) {
                                onUpdateOtpValuesByIndex(index, "")
                                focusRequesters[index - 1].requestFocus()
                            } else {
                                onUpdateOtpValuesByIndex(index, "")
                            }
                            true
                        } else {
                            false
                        }
                    },
                value = value,
                onValueChange = { newValue ->
                    // To use OTP code copied from keyboard
                    if (newValue.length == otpLength) {
                        for (i in otpValues.indices) {
                            onUpdateOtpValuesByIndex(
                                i,
                                if (i < newValue.length && newValue[i].isDigit()) newValue[i].toString() else ""
                            )
                        }

                        keyboardController?.hide()
                        onOtpInputComplete() // you should validate the otp values first for, if it is only digits or isNotEmpty
                    } else if (newValue.length <= 1) {
                        onUpdateOtpValuesByIndex(index, newValue)
                        if (newValue.isNotEmpty()) {
                            if (index < otpLength - 1) {
                                focusRequesters[index + 1].requestFocus()
                            } else {
                                keyboardController?.hide()
                                focusManager.clearFocus()
                                onOtpInputComplete()
                            }
                        }
                    } else {
                        if (index < otpLength - 1) focusRequesters[index + 1].requestFocus()
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = if (index == otpLength - 1) ImeAction.Done else ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        if (index < otpLength - 1) {
                            focusRequesters[index + 1].requestFocus()
                        }
                    },
                    onDone = {
                        keyboardController?.hide()
                        focusManager.clearFocus()
                        onOtpInputComplete()
                    }
                ),
                shape = MaterialTheme.shapes.small,
                isError = isError,
                textStyle = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize
                )
            )

            LaunchedEffect(value) {
                if (otpValues.all { it.isNotEmpty() }) {
                    focusManager.clearFocus()
                    onOtpInputComplete()
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        focusRequesters.first().requestFocus()
    }
}