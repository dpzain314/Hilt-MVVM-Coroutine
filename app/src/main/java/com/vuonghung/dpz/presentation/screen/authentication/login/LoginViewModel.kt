package com.vuonghung.dpz.presentation.screen.authentication.login

import androidx.lifecycle.ViewModel
import com.vuonghung.dpz.data.repository.MainRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val mainRepository: MainRepository): ViewModel() {
    val login = mainRepository.loginApp()
}