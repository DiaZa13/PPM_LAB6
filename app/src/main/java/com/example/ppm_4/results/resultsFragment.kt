package com.example.ppm_4.results

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

import com.example.ppm_4.R
import com.example.ppm_4.databinding.FragmentResultsBinding
import com.example.ppm_4.databinding.FragmentStartBinding
import com.example.ppm_4.models.Guest
import com.example.ppm_4.models.Guests
import java.lang.ClassCastException

/**
 * A simple [Fragment] subclass.
 */
class resultsFragment : Fragment() {

    private lateinit var viewModel: ResultsFragmentViewModel
    private lateinit var binding : FragmentResultsBinding
    private lateinit var guests : Guests //questionuser

    var msg:String? = " "

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_results, container, false)

        binding.btnReload.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_resultsFragment_to_registerFragment)

        }


        binding.btnGuests.setOnClickListener{
            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ResultsFragmentViewModel::class.java)
        // TODO: Use the ViewModel
        binding.viewModel = viewModel
        updateVisibleGuests()
        msg = viewModel.aGuest.value
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
            viewModel.updateGuest(guests.guests.size, guests.guests[guestIndex])
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)
    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            super.onOptionsItemSelected(item)

            if(item.itemId == R.id.share){
                val intent = Intent()
                intent.action=Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, msg)
                intent.type="text/plain"
                startActivity(Intent.createChooser(intent, "Share to:"))
            }
            return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
        }


}

