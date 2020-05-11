package com.example.ppm_4.results

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class resultsFragmentViewModel : ViewModel() {

    private val _totalGuests = MutableLiveData<Int>()
    val totalGuests : LiveData<Int>
    get() = _totalGuests

    private val _totalRegistered = MutableLiveData<Int>()
    val totalRegistered : LiveData<Int>
    get() = _totalRegistered

    private val _aGuest = MutableLiveData<String>()
    val aGuest : LiveData<String>
    get() = _aGuest
}