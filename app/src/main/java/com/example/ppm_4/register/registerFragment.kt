package com.example.ppm_4.register

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

import com.example.ppm_4.R
import com.example.ppm_4.databinding.FragmentRegisterBinding
import com.example.ppm_4.models.Guest
import com.example.ppm_4.models.Guests
import java.lang.ClassCastException

/**
 * A simple [Fragment] subclass.
 */
class registerFragment : Fragment() {

    companion object{
        fun newInstance() = registerFragment()
    }

    private lateinit var viewModel: RegisterFragmentViewModel
    private lateinit var guests : Guests //questionuser
    private lateinit var binding:FragmentRegisterBinding
    private var guestIndex = 0
    private var mensaje = " "

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_register, container, false)

        setHasOptionsMenu(true)
        return binding.root
    }


    //ViewModel
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterFragmentViewModel::class.java)
        // TODO: Use the ViewModel
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
        updateVisibleGuests()
    }

    //ActionBar
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.action_bar, menu)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            guests = context as Guests
        }catch (castException : ClassCastException){

        }
    }

    //SelectedButtonActionBar
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.registered -> {
            // User chose the "Settings" item, show the app settings UI...
            updateVisibleGuests()
            true
        }
        R.id.Notregistered -> {
            // User chose the "Settings" item, show the app settings UI...
            updateVisibleGuests()

            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    fun updateVisibleGuests(){
        guestIndex ++
        if(guests.guests.size > guestIndex-1){
            viewModel.updateGuest(guests.guests[guestIndex -1])
            (activity as AppCompatActivity).supportActionBar?.title = "Registrando (" + guestIndex + "/ " + guests.guests.size+")"
        }
    }




}