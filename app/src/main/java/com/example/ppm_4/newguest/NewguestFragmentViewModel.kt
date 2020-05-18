package com.example.ppm_4.newguest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ppm_4.database.Guest
import com.example.ppm_4.database.GuestDatabaseDao
import kotlinx.coroutines.*

class NewguestFragmentViewModel(val database: GuestDatabaseDao) : ViewModel() {

    val name = MutableLiveData<String>()
    val phone = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val role = MutableLiveData<String>()

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun insertGuest() {
        uiScope.launch {
            insert()
        }
    }

    private suspend fun insert(){
        withContext(Dispatchers.IO) {
            database.insert(Guest(name = name.value?:"", phone = phone.value?:"",email = email.value?:""))
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}