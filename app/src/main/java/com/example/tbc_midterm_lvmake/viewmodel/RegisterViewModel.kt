package com.example.tbc_midterm_lvmake.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.auth.User

class RegisterViewModel : ViewModel() {

    val isRegistered = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    var fullName = ""
    var email = ""
    var password = ""

    @SuppressLint("RestrictedApi")
    fun register(mAuth: FirebaseAuth) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                val user = User(email, password)
                FirebaseDatabase.getInstance().getReference("Users")
                    .child(FirebaseAuth.getInstance().currentUser!!.uid)
                    .setValue(user)
                    .addOnCompleteListener { task ->
                        isRegistered.value = task.isSuccessful
                        mAuth.currentUser!!.sendEmailVerification()
                    }
            } else {
                isRegistered.value = false
                error.value = it.exception!!.message.toString()
            }
        }
    }


}