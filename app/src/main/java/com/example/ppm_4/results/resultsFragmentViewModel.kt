package com.example.ppm_4.results

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultsFragmentViewModel : ViewModel() {

    private val _totalGuests = MutableLiveData<String>()
    val totalGuests : LiveData<String>
    get() = _totalGuests

    private val _totalRegistered = MutableLiveData<String>()
    val totalRegistered : LiveData<String>
    get() = _totalRegistered

    private val _aGuest = MutableLiveData<String>()
    val aGuest : LiveData<String>
    get() = _aGuest


}