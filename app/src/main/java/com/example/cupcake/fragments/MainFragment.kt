package com.example.cupcake.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.cupcake.R

class MainFragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_main, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    view.findViewById<Button>(R.id.one_cupcake).setOnClickListener { orderCupcake(1) }
    view.findViewById<Button>(R.id.six_cupcakes).setOnClickListener { orderCupcake(6) }
    view.findViewById<Button>(R.id.twelve_cupcakes).setOnClickListener { orderCupcake(12) }
  }

  private fun orderCupcake(quantity: Int) {
    Log.d("test", "Quantity $quantity")
  }
}