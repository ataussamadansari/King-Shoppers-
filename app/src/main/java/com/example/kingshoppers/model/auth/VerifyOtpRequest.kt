package com.example.kingshoppers.model.auth

data class VerifyOtpRequest(
    val phone: String,
    val otp: String
)
