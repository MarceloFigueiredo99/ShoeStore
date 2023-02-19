package com.udacity.shoestore.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.list.ShoeListViewModel
import timber.log.Timber

class DetailsFragment : Fragment() {

    lateinit var detailViewModel: DetailsViewModel
    val shoeListViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDetailsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_details,
            container,
            false
        )

        detailViewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        binding.detailViewModel = detailViewModel
        binding.lifecycleOwner = this

        binding.buttonCancel.setOnClickListener {
            findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToShoeListFragment())
        }

        binding.buttonSave.setOnClickListener {
            Timber.i("Valid: ${detailViewModel.validParameters()}")
            if (detailViewModel.validParameters()) {
                val newShoe = detailViewModel.createShoe()
                shoeListViewModel.addShoe(newShoe)
                findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToShoeListFragment())
            } else {
                Toast.makeText(context, "Please fill out the details", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}