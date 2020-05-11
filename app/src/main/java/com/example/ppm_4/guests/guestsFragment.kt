package com.example.ppm_4.guests

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.ppm_4.R
import com.example.ppm_4.databinding.FragmentGuestsBinding
import com.example.ppm_4.databinding.FragmentStartBinding

/**
 * A simple [Fragment] subclass.
 */
class guestsFragment : Fragment() {

    private lateinit var viewModel: guestsFragmentViewModel

    private lateinit var  binding: FragmentGuestsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_guests, container, false)
        binding.setLifecycleOwner(this)

        binding.btnNewguest.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_guestsFragment2_to_newguestFragment)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(guestsFragmentViewModel::class.java)
        // TODO: Use the ViewModel

    }


}

