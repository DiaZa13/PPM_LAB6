package com.example.ppm_4.guests

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class guestsFragmentViewModel :  ViewModel() {

    private val _guestList = MutableLiveData<List<String>>()
    val guestList : LiveData<List<String>>
    get() = _guestList

    private val _guests = MutableLiveData<String>()
    val guests : LiveData<String>
    get () = _guests



}