package com.example.cupcake.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class OrderViewModel : ViewModel() {
  private val _quantity = MutableLiveData<Int>()
  val quantity: LiveData<Int> = _quantity

  private val _flavor = MutableLiveData<String>()
  val flavor: LiveData<String> = _flavor

  private val _date = MutableLiveData<String>()
  val date: LiveData<String> = _date

  private val _price = MutableLiveData<Double>()
  val price: LiveData<Double> = _price

  val dateOptions = getPickupOptions()

  fun setQuantity(quantity: Int) {
    _quantity.value = quantity
  }

  fun setFlavor(flavor: String) {
    _flavor.value = flavor
  }

  fun setDate(date: String) {
    _date.value = date
  }

  fun hasNoFlavorSet(): Boolean {
    return _flavor.value.isNullOrEmpty()
  }

  private fun getPickupOptions(): List<String> {
    val options = mutableListOf<String>()
    val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
    val calendar = Calendar.getInstance()
    repeat(4) {
      options.add(formatter.format(calendar.time))
      calendar.add(Calendar.DATE, 1)
    }
    return options
  }

  fun resetOrder() {
    _quantity.value = 0
    _flavor.value = ""
    _date.value = dateOptions[0]
    _price.value = 0.0
  }

  init {
    resetOrder()
  }
}
