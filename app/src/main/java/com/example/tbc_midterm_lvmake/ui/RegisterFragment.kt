package com.example.tbc_midterm_lvmake.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tbc_midterm_lvmake.R
import com.example.tbc_midterm_lvmake.databinding.FragmentRegisterBinding
import com.example.tbc_midterm_lvmake.viewmodel.RegisterViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_welcome.*

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        mAuth = FirebaseAuth.getInstance()

        val viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        binding.RegisterBtn.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val userName = binding.userEditText.text.toString()


            if (userName.isEmpty()) {
                binding.userEditText.error = "Puno ime je obavezno!"
                binding.userEditText.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                binding.emailEditText.error = "Email je obavezan!"
                binding.emailEditText.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.emailEditText.error = "Molimo unesite vazeci email!"
                binding.emailEditText.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.passwordEditText.error = "Password je obavezan!"
                binding.passwordEditText.requestFocus()
                return@setOnClickListener
            }
            if (password.length < 6) {
                binding.passwordEditText.error = "Password mora biti duzi od 6!"
                binding.passwordEditText.requestFocus()
                return@setOnClickListener
            }

            binding.progressBar.visibility = View.VISIBLE

            viewModel.email = email
            viewModel.password = password
            viewModel.fullName = userName

            viewModel.register(mAuth)

        }

        viewModel.isRegistered.observe(viewLifecycleOwner, Observer {
            if (it) {
                Snackbar.make(view,"Uspjesno registrovan korisnik", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(Color.GREEN).show()
                binding.progressBar.visibility = View.GONE
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            } else {
                binding.progressBar.visibility = View.GONE
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer {
            Snackbar.make(view,it, Snackbar.LENGTH_SHORT).setBackgroundTint(Color.RED).show()
        })

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}