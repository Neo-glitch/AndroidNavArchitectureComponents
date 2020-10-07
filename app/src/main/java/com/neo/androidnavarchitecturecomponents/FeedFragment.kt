package com.neo.androidnavarchitecturecomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.neo.androidnavarchitecturecomponents.feed.BOATS
import com.neo.androidnavarchitecturecomponents.feed.BoatsAdapter
import kotlinx.android.synthetic.main.fragment_feed.view.*

class FeedFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_feed, container, false)
        view.recycler.adapter = BoatsAdapter(BOATS, ::onBoatClick)
        view.recycler.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

    private fun onBoatClick(boatId: Int) {
        // normal way to pass args with navArch
//        val args = Bundle()
//        args.putInt("id", boatId)
//        activity?.findNavController(R.id.nav_container)?.navigate(R.id.boatFragment, args)

        // safe args call way of doing this
        val action = HomeFragmentDirections.actionHomeFragmentToBoatFragment(boatId)    // passes this boatId as arg to action
        activity?.findNavController(R.id.nav_container)?.navigate(action)
    }


}