package com.example.ppm_4.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ppm_4.database.Guest
import com.example.ppm_4.database.GuestDatabaseDao
import kotlinx.coroutines.*

class RegisterFragmentViewModel(val database: GuestDatabaseDao) : ViewModel() {

    val guests = database.getAllGuests()

    private val _registerComplete = MutableLiveData<Boolean>()
    val registerComplete: LiveData<Boolean>
        get() = _registerComplete

    var guestIndex = 1
        private set

    var totalGuests = 0
        private set

    val actualGuest = MutableLiveData<Guest>()

    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun initialize(guests: List<Guest>) {
        totalGuests = guests.size
        if (guests.isEmpty()) {
            _registerComplete.value = true
        } else {
            actualGuest.value = guests[0]
        }
    }

    fun updateRegisteredCurrentQuestion() {
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

    fun updateNotRegisteredCurrentQuestion() {
        val guest = actualGuest.value
        guest?.registered = "No"
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