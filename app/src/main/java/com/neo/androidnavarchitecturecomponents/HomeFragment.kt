package com.neo.androidnavarchitecturecomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // sets up bottomNav using nav arch
        val navHostFragment = childFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        view.bottomNavigationView.setupWithNavController(navController = navHostFragment.navController)

        // sets up toolbar, to change based on childFragment shown using custom navigated listener
        val toolbar = view.toolbar
        navHostFragment.navController.addOnDestinationChangedListener { controller, destination, arguments ->
            toolbar.title = destination.label
        }

        return view
    }
}