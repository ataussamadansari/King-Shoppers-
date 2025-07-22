package com.example.kingshoppers.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kingshoppers.model.auth.SendOtpRequest
import com.example.kingshoppers.model.auth.SendOtpResponse
import com.example.kingshoppers.model.auth.VerifyOtpRequest
import com.example.kingshoppers.model.auth.VerifyOtpResponse
import com.example.kingshoppers.repository.UserRepository
import com.example.kingshoppers.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val sendOtpLiveData : LiveData<NetworkResult<SendOtpResponse>>
        get() = userRepository.sendOtpLiveData

    val verifyOtpLiveData : LiveData<NetworkResult<VerifyOtpResponse>>
        get() = userRepository.verifyOtpLiveData


    fun sendOtp(sendOtpRequest: SendOtpRequest) {
        viewModelScope.launch {
            userRepository.sendOtp(sendOtpRequest)
        }
    }

    fun verifyOtp(verifyOtpRequest: VerifyOtpRequest) {
        viewModelScope.launch {
            userRepository.verifyOtp(verifyOtpRequest)
        }
    }
}