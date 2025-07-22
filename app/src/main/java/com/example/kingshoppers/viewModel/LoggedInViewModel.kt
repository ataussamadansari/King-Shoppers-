package com.example.kingshoppers.viewModel

import androidx.lifecycle.ViewModel
import com.example.kingshoppers.utils.TokenManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoggedInViewModel @Inject constructor(private val tokenManager: TokenManager) : ViewModel() {
    fun isLoggedIn(): Boolean {
        return tokenManager.getToken() != null
    }

    fun saveToken(token: String) {
        tokenManager.saveToken(token)
    }
}