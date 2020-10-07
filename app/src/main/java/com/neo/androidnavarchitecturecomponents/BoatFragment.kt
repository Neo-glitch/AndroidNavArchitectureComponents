package com.neo.androidnavarchitecturecomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.neo.androidnavarchitecturecomponents.feed.BOATS
import com.neo.androidnavarchitecturecomponents.feed.getBoat
import kotlinx.android.synthetic.main.fragment_boat.view.*
import kotlinx.android.synthetic.main.item_boat.view.locationTextView
import kotlinx.android.synthetic.main.item_boat.view.nameTextView


class BoatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // normal way of retrieving args using nav arch
//        val id = arguments?.getInt("id") ?: error("id is null")
        // retrieve args using safe args method
//        val id = BoatFragmentArgs.fromBundle(arguments).id

        // retrieve args from deepLink normal way else use id from the safeargs if id_dl key not there
        val id = arguments?.getString("id_dl")?.toInt() ?:
                BoatFragmentArgs.fromBundle(arguments).id

        val boat = BOATS.getBoat(id)

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_boat, container, false)
        view.nameTextView.text = boat.name
        view.locationTextView.text = boat.location
        view.imageView3.setImageResource(boat.picture)
        view.priceTextView2.text = boat.price

        return view
    }
}