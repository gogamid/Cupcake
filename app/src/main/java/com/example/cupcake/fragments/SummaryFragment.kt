package com.example.cupcake.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.R
import com.example.cupcake.databinding.FragmentSummaryBinding
import com.example.cupcake.model.OrderViewModel


class SummaryFragment : Fragment() {

  private val sharedViewModel: OrderViewModel by activityViewModels()
  private lateinit var binding: FragmentSummaryBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    // Inflate the layout for this fragment
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_summary, container, false)
    return binding.root
  }


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.apply {
      viewModel = sharedViewModel
      lifecycleOwner = viewLifecycleOwner
      summaryFragment = this@SummaryFragment
    }
  }

  fun sendOrder() {
    val numberOfCupcakes = sharedViewModel.quantity.value ?: 0
    val orderSummary = getString(
      R.string.order_details,
      resources.getQuantityString(R.plurals.cupcakes, numberOfCupcakes, numberOfCupcakes),
      sharedViewModel.flavor.value.toString(),
      sharedViewModel.date.value.toString(),
      sharedViewModel.price.value.toString()
    )

    val intent = Intent(Intent.ACTION_SEND)
      .setType("text/plain")
      .putExtra(Intent.EXTRA_SUBJECT, getString(R.string.new_cupcake_order))
      .putExtra(Intent.EXTRA_TEXT, orderSummary)

    if (activity?.packageManager?.resolveActivity(intent, 0) != null) {
      startActivity(intent)
    }
  }

  fun cancelOrder() {
    sharedViewModel.resetOrder()
    findNavController().navigate(R.id.action_summaryFragment_to_mainFragment)
  }
}