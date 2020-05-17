package com.example.ppm_4.newrole

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil

import com.example.ppm_4.R
import com.example.ppm_4.databinding.NewroleFragmentBinding
import com.example.ppm_4.models.Guests
import com.example.ppm_4.newguest.newguestFragmentViewModel

class newroleFragment : Fragment() {

    private lateinit var viewModel: newguestFragmentViewModel
    private lateinit var  binding: NewroleFragmentBinding
    private lateinit var guests : Guests //questionuser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.newrole_fragment, container, false)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.newguest_menu, menu)
    }

}
