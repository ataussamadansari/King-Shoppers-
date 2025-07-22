package com.example.kingshoppers.model.auth

data class SendOtpResponse(
    val success: Boolean,
    val message: String,
    val results: OtpResults
)

data class OtpResults(
    val phone: String,
    val isRegistered: Boolean,
    val otp: String
)
