package com.example.ppm_4.guests

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.ppm_4.database.Guest
import com.example.ppm_4.database.GuestDatabaseDao
import java.lang.StringBuilder

class GuestsFragmentViewModel(val database:GuestDatabaseDao):  ViewModel() {

    private val types = database.getAllGuests()

    val guestText = Transformations.map(types) {
        buildGuestText(it)
    }

    private fun buildGuestText(types: List<Guest>) : String{
        val guestText = StringBuilder()
        for (type in types){
            guestText.append("Invitado: ${type.Id}\nNombre: ${type.name}\nTelefono: ${type.phone}\nEmail: ${type.email}\n\n")
        }
        return guestText.toString()
    }


}