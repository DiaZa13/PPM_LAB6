package com.example.ppm_4.guests

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.ppm_4.R
import com.example.ppm_4.databinding.FragmentGuestsBinding
import com.example.ppm_4.databinding.FragmentStartBinding
import com.example.ppm_4.models.Guests
import java.lang.ClassCastException

/**
 * A simple [Fragment] subclass.
 */
class guestsFragment : Fragment() {

    private lateinit var viewModel: GuestsFragmentViewModel
    private lateinit var  binding: FragmentGuestsBinding
    private lateinit var guests : Guests //questionuser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_guests, container, false)
       // binding.setLifecycleOwner(this)
        binding.btnNewguest.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_guestsFragment2_to_newguestFragment)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GuestsFragmentViewModel::class.java)
        // TODO: Use the ViewModel
        binding.viewModel = viewModel
        updateVisibleGuests()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            guests = context as Guests
        }catch (castException : ClassCastException){

        }
    }

    fun updateVisibleGuests() {
        for(guestIndex in 0..guests.guests.size -1){
            viewModel.updateGuest(guests.guests[guestIndex], guestIndex + 1)
        }

    }


}

