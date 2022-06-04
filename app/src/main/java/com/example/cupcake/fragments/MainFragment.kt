package com.example.cupcake.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.R
import com.example.cupcake.databinding.FragmentFlavorBinding
import com.example.cupcake.databinding.FragmentMainBinding
import com.example.cupcake.model.OrderViewModel

class MainFragment : Fragment() {
  private val sharedViewModel: OrderViewModel by activityViewModels()
  private lateinit var binding: FragmentMainBinding
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.startFragment = this
  }

  fun orderCupcake(quantity: Int) {
    sharedViewModel.setQuantity(quantity)
    if (sharedViewModel.hasNoFlavorSet()) {
      sharedViewModel.setFlavor(getString(R.string.vanilla))
    }
    findNavController().navigate(R.id.action_mainFragment_to_flavorFragment)
  }
}