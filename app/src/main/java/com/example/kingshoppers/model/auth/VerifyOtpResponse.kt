package com.example.kingshoppers.model.auth

data class VerifyOtpResponse(
    val success: Boolean,
    val message: String,
    val results: VerifyResults
)

data class VerifyResults(
    val token: String,
    val user: User,
    val isRegistered: Boolean
)

data class User(
    val _id: String,
    val phone: String,
    val isVerified: Boolean
)
