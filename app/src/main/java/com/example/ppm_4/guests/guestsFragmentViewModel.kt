package com.example.ppm_4.guests

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ppm_4.models.Guest

class GuestsFragmentViewModel :  ViewModel() {

    private val _guestList = MutableLiveData<ArrayList<Guest>>()
    val guestList : LiveData<ArrayList<Guest>>
    get() = _guestList

    private val _guests = MutableLiveData<String>()
    val guests : LiveData<String>
    get () = _guests

    fun updateGuest(guest : Guest,guestIndex : Int){
        _guestList.value?.add(guest)
        _guests.value = if(_guests.value == null) {""}else{_guests.value} + "Invitado: " + guestIndex + "\nNombre: " + guest.name + "\nTeléfono: " + guest.phone + "\nEmail: " + guest.email + "\n\n"
    }
    
}