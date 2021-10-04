package com.vuonghung.dpz.presentation.screen.main

import androidx.lifecycle.ViewModel
import com.vuonghung.dpz.data.repository.MainRepository
import javax.inject.Inject

class MainViewModel @Inject constructor( private val mainRepository: MainRepository): ViewModel() {
    val listUsers = mainRepository.getUsers()
}