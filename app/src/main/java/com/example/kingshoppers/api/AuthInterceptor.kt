package com.example.kingshoppers.api

import com.example.kingshoppers.utils.TokenManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    @Inject
    lateinit var tokenManger: TokenManager

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        val token = tokenManger.getToken()
        request.addHeader("Authorization", "Bearer $token")


        return chain.proceed(request.build())
    }
}