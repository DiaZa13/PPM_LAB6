package com.example.ppm_4.newguest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ppm_4.models.Guest as Guest

class newguestFragmentViewModel : ViewModel() {

    private val _newguest = MutableLiveData<Guest>()
    val newguest : LiveData<Guest>
    get() = _newguest

    private val _save = MutableLiveData<Boolean>()
    val save : LiveData<Boolean>
    get() = _save

    init{
    _save.value = false
    }

    fun saved(){
        _save.value = true
    }

    fun addNewGuest(name:String, phone : String, email : String) : Guest{
        _newguest.value = Guest(name,phone,email)
        return _newguest.value!!
    }
}