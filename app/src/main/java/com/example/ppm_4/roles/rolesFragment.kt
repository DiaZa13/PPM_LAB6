package com.example.ppm_4.roles

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ppm_4.R

class rolesFragment : Fragment() {

    companion object {
        fun newInstance() = rolesFragment()
    }

    private lateinit var viewModel: RolesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_roles, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RolesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
