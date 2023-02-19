package com.udacity.shoestore.list

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoelistBinding
import com.udacity.shoestore.databinding.ShoeViewBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListFragment : Fragment() {

    lateinit var binding: FragmentShoelistBinding
    val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoelist,
            container,
            false
        )

        binding.lifecycleOwner = this
        setHasOptionsMenu(true)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoe_list ->
            for (shoe in shoe_list) {
                addShoeToView(container, shoe)
            }
        })

        binding.floatingDetails.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToDetailsFragment())
        }

        return binding.root
    }

    fun addShoeToView(container: ViewGroup?, shoe: Shoe) {
        val shoeBinding: ShoeViewBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.shoe_view, container, false
        )
        shoeBinding.shoe = shoe
        Timber.i("Shoe binding ${shoeBinding.shoe}")
        binding.shoeItems.addView(shoeBinding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}
