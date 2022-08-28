package com.example.tbc_midterm_lvmake.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.tbc_midterm_lvmake.BaseFragment
import com.example.tbc_midterm_lvmake.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(
    FragmentWelcomeBinding::inflate
) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            loginBtn.setOnClickListener {
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment())
            }
            registerBtn.setOnClickListener {
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToRegistrationFragment())
            }
        }

    }

    override fun init() {
        TODO("Not yet implemented")
    }

}