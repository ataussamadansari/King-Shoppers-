package com.example.kingshoppers.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kingshoppers.api.UserAPI
import com.example.kingshoppers.model.auth.SendOtpRequest
import com.example.kingshoppers.model.auth.SendOtpResponse
import com.example.kingshoppers.model.auth.VerifyOtpRequest
import com.example.kingshoppers.model.auth.VerifyOtpResponse
import com.example.kingshoppers.utils.NetworkResult
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val userAPI: UserAPI) {

    private val _sendOtpLiveData = MutableLiveData<NetworkResult<SendOtpResponse>>()
    val sendOtpLiveData: LiveData<NetworkResult<SendOtpResponse>>
        get() = _sendOtpLiveData

    private val _verifyOtpLiveData = MutableLiveData<NetworkResult<VerifyOtpResponse>>()
    val verifyOtpLiveData: LiveData<NetworkResult<VerifyOtpResponse>>
        get() = _verifyOtpLiveData


    suspend fun sendOtp(sendOtpRequest: SendOtpRequest) {
        _sendOtpLiveData.postValue(NetworkResult.Loading())

        val response = userAPI.sendOtp(sendOtpRequest)
        handleApiResponse(response)
    }

    suspend fun verifyOtp(verifyOtpRequest: VerifyOtpRequest) {
        _verifyOtpLiveData.postValue(NetworkResult.Loading())

        val response = userAPI.verifyOtp(verifyOtpRequest)
        handleApiResponse(response)
    }


    private fun <T> handleApiResponse(response: Response<T>): NetworkResult<T> {
        return if (response.isSuccessful && response.body() != null) {
            NetworkResult.Success(response.body()!!)
        } else {
            val errorMessage = response.errorBody()?.string() ?: "Something went wrong"
            NetworkResult.Error(errorMessage)
        }
    }
}