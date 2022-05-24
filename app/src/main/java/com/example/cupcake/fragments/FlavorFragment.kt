package com.example.cupcake.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.cupcake.R

class FlavorFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_flavor, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    view.findViewById<Button>(R.id.next_button).setOnClickListener { goToNextScreen() }
  }

  private fun goToNextScreen() {
    findNavController().navigate(R.id.action_flavorFragment_to_pickupDateFragment)
  }
}