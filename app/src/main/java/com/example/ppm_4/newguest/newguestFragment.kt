package com.example.ppm_4.newguest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.ppm_4.R
import com.example.ppm_4.databinding.FragmentGuestsBinding
import com.example.ppm_4.databinding.FragmentNewguestBinding
import com.example.ppm_4.databinding.FragmentStartBinding
import com.example.ppm_4.models.Guest
import com.example.ppm_4.models.Guests
import kotlinx.android.synthetic.main.fragment_newguest.*
import java.lang.ClassCastException

/**
 * A simple [Fragment] subclass.
 */
class newguestFragment : Fragment() {

    private lateinit var viewModel: newguestFragmentViewModel
    private lateinit var  binding: FragmentNewguestBinding
    private lateinit var guests : Guests //questionuser


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_newguest, container, false)

        binding.setLifecycleOwner(this)


        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(newguestFragmentViewModel::class.java)
        // TODO: Use the ViewModel
        viewModel.save.observe(viewLifecycleOwner, Observer { isSaved ->
            if (isSaved){
                val name = txtName.getText().toString()
                val phone = txtPhone.getText().toString()
                val email = txtEmail.getText().toString()
                guests.guests.add(viewModel.addNewGuest(name,phone,email))
            }
        })

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            guests = context as Guests
        }catch (castException : ClassCastException){

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.newguest_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        if(item.itemId == R.id.save){
        viewModel.saved()
            view?.findNavController()?.navigate(R.id.action_newguestFragment_to_guestsFragment2)
        }

        if(item.itemId == R.id.close){
            view?.findNavController()?.navigate(R.id.action_newguestFragment_to_guestsFragment2)
        }
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
    }
}





