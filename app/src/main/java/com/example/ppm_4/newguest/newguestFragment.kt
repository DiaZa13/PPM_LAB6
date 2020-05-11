package com.example.ppm_4.newguest

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.ppm_4.R
import com.example.ppm_4.databinding.FragmentNewguestBinding

/**
 * A simple [Fragment] subclass.
 */
class newguestFragment : Fragment() {

    private lateinit var viewModel: newguestFragmentViewModel

    private lateinit var  binding: FragmentNewguestBinding
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
                view?.findNavController()?.navigate(R.id.action_newguestFragment_to_guestsFragment2)
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.newguest_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.save-> {
            // User chose the "Settings" item, show the app settings UI...
            val savedResult = viewModel.saved()
            true
        }
        R.id.close -> {
            // User chose the "Settings" item, show the app settings UI...
            view?.findNavController()?.navigate(R.id.action_newguestFragment_to_guestsFragment2)
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }


}

