package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.MainViewModel
import kotlinx.android.synthetic.main.shoe_item.view.*

class ShoeListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater,
            R.layout.fragment_shoe_list, container, false
        )

        binding.addShoeFab.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        (activity as MainActivity).supportActionBar?.title =
            getString(R.string.shoelist_fragment_title)

        val viewModel: MainViewModel by activityViewModels()

        // Add observer for shoes
        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->
            for (item in shoes) {
                val child: View = getLayoutInflater().inflate(R.layout.shoe_item, null);
                child.name.text = item.name
                binding.shoelistLn.addView(child)
            }
        })

        return binding.root
    }
}
