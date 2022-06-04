package com.example.cupcake.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.R
import com.example.cupcake.databinding.FragmentFlavorBinding
import com.example.cupcake.databinding.FragmentPickupDateBinding
import com.example.cupcake.model.OrderViewModel

class PickupDateFragment : Fragment() {

  private val sharedViewModel: OrderViewModel by activityViewModels()
  private lateinit var binding: FragmentPickupDateBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pickup_date, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding.viewModel = sharedViewModel
    binding.lifecycleOwner = viewLifecycleOwner
    view.findViewById<Button>(R.id.next_button).setOnClickListener { goToNextScreen() }
  }

  private fun goToNextScreen() {
    findNavController().navigate(R.id.action_pickupDateFragment_to_summaryFragment)
  }
}