package com.example.kingshoppers.api

import com.example.kingshoppers.model.auth.SendOtpRequest
import com.example.kingshoppers.model.auth.SendOtpResponse
import com.example.kingshoppers.model.auth.VerifyOtpRequest
import com.example.kingshoppers.model.auth.VerifyOtpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("auth/send-otp")
    suspend fun sendOtp(@Body otpRequest: SendOtpRequest) : Response<SendOtpResponse>

    @POST("auth/verify-otp")
    suspend fun verifyOtp(@Body verifyOtpRequest: VerifyOtpRequest) : Response<VerifyOtpResponse>
}