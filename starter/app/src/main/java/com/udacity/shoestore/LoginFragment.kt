package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,
            R.layout.fragment_login,container,false)

        binding.registerBtn.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

        binding.loginBtn.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

        (activity as MainActivity).supportActionBar?.title = getString(R.string.login_fragment_title)

        return binding.root
    }
}
