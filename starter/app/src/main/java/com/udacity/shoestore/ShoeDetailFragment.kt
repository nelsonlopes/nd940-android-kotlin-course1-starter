package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.MainViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(inflater,
            R.layout.fragment_shoe_detail,container,false)

        binding.cancelBtn.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        val viewModel: MainViewModel by activityViewModels()

        binding.saveBtn.setOnClickListener { view : View ->
            viewModel.newShoe(binding.shoenameEt.text.toString(),
                binding.shoesizeEt.text.toString().toDouble(),
                binding.companyEt.text.toString(),
                binding.descriptionEt.text.toString())
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        (activity as MainActivity).supportActionBar?.title = getString(R.string.shoedetail_fragment_title)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)

        return binding.root
    }
}
