package com.example.ppm_4.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ppm_4.models.Guest

class RegisterFragmentViewModel : ViewModel() {

    private val _actualGuest = MutableLiveData<Guest>()
    val actualGuest : LiveData<Guest>
    get() = _actualGuest

    private val _isRegister = MutableLiveData<Boolean>()
    val isRegister : LiveData<Boolean>
    get() = _isRegister

    private val _isNotregister = MutableLiveData<Boolean>()
    val isNotregister : LiveData<Boolean>
    get() = _isNotregister

    fun updateGuest(guest : Guest){
        _actualGuest.value = guest
    }

    }