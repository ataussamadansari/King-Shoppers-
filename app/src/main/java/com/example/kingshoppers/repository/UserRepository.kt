package com.example.kingshoppers.repository

import android.util.Log
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
        val result = handleApiResponse(response)

        _sendOtpLiveData.postValue(result)
    }

    suspend fun verifyOtp(verifyOtpRequest: VerifyOtpRequest) {
        _verifyOtpLiveData.postValue(NetworkResult.Loading())

        val response = userAPI.verifyOtp(verifyOtpRequest)
        val result = handleApiResponse(response)

        _verifyOtpLiveData.postValue(result)
    }


    private fun <T> handleApiResponseOld(response: Response<T>): NetworkResult<T> {
        return if (response.isSuccessful && response.body() != null) {
            NetworkResult.Success(response.body()!!)
        } else {
            val errorMessage = response.errorBody()?.string() ?: "Something went wrong"
            NetworkResult.Error(errorMessage)
        }
    }

    private fun <T> handleApiResponse(response: Response<T>): NetworkResult<T> {
        return if (response.isSuccessful && response.body() != null) {
            NetworkResult.Success(response.body()!!)
        } else {
            val errorMessage = response.errorBody()?.string() ?: "Something went wrong"
            NetworkResult.Error(errorMessage)
        }
    }

    fun clearSendOtpLiveData() {
        _sendOtpLiveData.postValue(null)
    }

    fun clearVerifyOtpLiveData() {
        _verifyOtpLiveData.postValue(null)
    }


}