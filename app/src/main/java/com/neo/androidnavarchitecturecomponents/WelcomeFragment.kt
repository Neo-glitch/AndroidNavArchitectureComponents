package com.neo.androidnavarchitecturecomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_welcome.*
import kotlinx.android.synthetic.main.fragment_welcome.view.*


class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        view.button_login.setOnClickListener {
            val email = view.editTextEmail.text.toString()
            val password = view.editTextPassword.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty()){
                // can also passed a bundle alongside the action to go to next fragment
                findNavController().navigate(R.id.action_welcomeFragment_to_homeFragment)
            }
        }

        view.button_registration.setOnClickListener(
            // takes us to reg fragment, instead of normal way with intents
            Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_registrationFragment)
        )

        return view
    }

}