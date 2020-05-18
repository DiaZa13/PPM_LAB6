package com.example.ppm_4.register

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ppm_4.R
import com.example.ppm_4.databinding.FragmentRegisterBinding


/**
 * A simple [Fragment] subclass.
 */
class registerFragment : Fragment() {

    companion object{
        fun newInstance() = registerFragment()
    }

    private lateinit var viewModel: RegisterFragmentViewModel
    private lateinit var binding:FragmentRegisterBinding
    private var guestIndex = 0
    private var tRegistered = 0

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
    }

    //ActionBar
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.action_bar, menu)
    }


    //SelectedButtonActionBar
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.registered -> {
            // User chose the "Settings" item, show the app settings UI...
            tRegistered += 1

            true
        }
        R.id.Notregistered -> {
            // User chose the "Settings" item, show the app settings UI...


            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }




}
