package com.vuonghung.dpz.presentation.screen.main

import androidx.lifecycle.ViewModel
import com.vuonghung.dpz.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(mainRepository: MainRepository): ViewModel() {
//    val listUsers = mainRepository.getUsers()

}