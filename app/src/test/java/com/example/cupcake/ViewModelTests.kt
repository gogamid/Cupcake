package com.example.cupcake

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cupcake.model.OrderViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

class ViewModelTests {
  @get:Rule
  var instantTaskExecutorRule = InstantTaskExecutorRule()

  @Test
  fun quantity_twelve_cupcakes() {
    val viewModel = OrderViewModel()
    viewModel.quantity.observeForever {}
    viewModel.setQuantity(12)
    assertEquals(12, viewModel.quantity.value)
  }
}