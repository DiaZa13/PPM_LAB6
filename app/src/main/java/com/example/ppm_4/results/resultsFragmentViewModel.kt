package com.example.ppm_4.results

import android.provider.SyncStateContract.Helpers.update
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.ppm_4.database.Guest
import com.example.ppm_4.database.GuestDatabaseDao
import kotlinx.coroutines.*

class ResultsFragmentViewModel(val database: GuestDatabaseDao) : ViewModel() {

    private val _aGuest = MutableLiveData<String>()
    val aGuest : LiveData<String>
        get() = _aGuest

    val guests = database.getAllGuests()


    var guestIndex = 1
        private set

    var totalGuests = 0


    var totalRegistered = 0

    private val _registerComplete = MutableLiveData<Boolean>()
    val registerComplete: LiveData<Boolean>
        get() = _registerComplete

    val actualGuest = MutableLiveData<Guest>()


    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun initialize(guests: List<Guest>) {
        totalGuests = guests.size
        for(guest in guests){
            _aGuest.value += guest.name + ": "+ guest.registered + " "
            if(guest.registered == "Sí")
                totalRegistered += 1
        }
    }

    fun updateRegisteredCurrentGuest() {
        val guest = actualGuest.value
        guest?.registered = "Sí"
        guestIndex++
        if (totalGuests >= guestIndex) {
            actualGuest.value = guests.value?.get(guestIndex - 1)
        } else {
            _registerComplete.value = true
        }
        uiScope.launch {
            update(guest)
        }
    }


    private suspend fun update(guest: Guest?) {
        withContext(Dispatchers.IO) {
            guest?.let {
                //                it.answer = answer.value ?: ""
                database.update(it)
            }
        }
    }

    fun finishRegister() {
        _registerComplete.value = false
        guestIndex = 1
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


}