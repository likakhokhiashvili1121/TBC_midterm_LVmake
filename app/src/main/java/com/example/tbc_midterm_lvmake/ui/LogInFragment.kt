package com.example.tbc_midterm_lvmake.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tbc_midterm_lvmake.BaseFragment
import com.example.tbc_midterm_lvmake.R
import com.example.tbc_midterm_lvmake.databinding.FragmentLogInBinding
import com.example.tbc_midterm_lvmake.viewmodel.LoginViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

    private var _binding: FragmentLogInBinding? = null
    private val binding get() = _binding!!

    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLogInBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        mAuth = FirebaseAuth.getInstance()



        val viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)



        binding.loginBtn.setOnClickListener {
            val email = binding.emailET.text.toString()
            val password = binding.passwordET.text.toString()

            if (email.isEmpty()) {
                binding.emailET.error = "Unesite email!"
                binding.emailET.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.emailET.error = "Unesite validan email!"
                binding.emailET.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.passwordET.error = "Unesite password!"
                binding.passwordET.requestFocus()
                return@setOnClickListener
            }
            if (password.length < 6) {
                binding.passwordET.error = "Unesite password duzi od 6!"
                binding.passwordET.requestFocus()
                return@setOnClickListener
            }

            binding.progressBar.visibility = View.VISIBLE

            viewModel.email = email
            viewModel.password = password

            viewModel.userLogin(mAuth)
        }

        viewModel.isAbleToLogin.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(R.id.action_loginFragment_to_HomeFragment)
            } else {
                binding.progressBar.visibility = View.GONE
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer {
            Snackbar.make(view, it, Snackbar.LENGTH_SHORT).setBackgroundTint(Color.RED).show()
        })

        viewModel.emailVerified.observe(viewLifecycleOwner, Observer {
            if (!it){
                Snackbar.make(view, "Molimo verifikujte vas racun!", Snackbar.LENGTH_LONG).setBackgroundTint(Color.RED).show()
                binding.progressBar.visibility = View.GONE
            }
        })

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}