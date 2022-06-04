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
import com.example.cupcake.model.OrderViewModel

class FlavorFragment : Fragment() {
  private val sharedViewModel: OrderViewModel by activityViewModels()
  private lateinit var binding: FragmentFlavorBinding
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    // Inflate the layout for this fragment
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flavor, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding.apply {
      viewModel = sharedViewModel
      lifecycleOwner = viewLifecycleOwner
      flavorFragment = this@FlavorFragment
    }
  }

  fun goToNextScreen() {
    findNavController().navigate(R.id.action_flavorFragment_to_pickupDateFragment)
  }
}