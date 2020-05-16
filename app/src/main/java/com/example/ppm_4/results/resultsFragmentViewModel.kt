package com.example.ppm_4.results

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ppm_4.models.Guest

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

    fun updateGuest(guestIndex : Int, guest : Guest){
        _totalGuests.value = guestIndex.toString()
        _totalRegistered.value = guest.tRegistered.toString()
        _aGuest.value = if(_aGuest.value == null) {""}else{_aGuest.value} + " " + guest.name  + ": " + guest.registered + "  "
    }
}