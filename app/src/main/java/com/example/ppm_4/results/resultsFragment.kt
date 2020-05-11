package com.example.ppm_4.results

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

/**
 * A simple [Fragment] subclass.
 */
class resultsFragment : Fragment() {

    private lateinit var viewModel: resultsFragmentViewModel

    var mensaje:String? = " "
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentResultsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_results, container, false)
        binding.btnReload.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_resultsFragment_to_registerFragment)

        }

        mensaje = arguments?.getString("Message")
        var contador = arguments?.getInt("Counter")
        binding.txtTRegistrados.text = "Registrados: " + contador.toString()

        binding.btnGuests.setOnClickListener{
            Toast.makeText(activity, mensaje, Toast.LENGTH_SHORT).show()
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(resultsFragmentViewModel::class.java)
        // TODO: Use the ViewModel
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
                intent.putExtra(Intent.EXTRA_TEXT, mensaje)
                intent.type="text/plain"
                startActivity(Intent.createChooser(intent, "Share to:"))
            }
            return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
        }

}

