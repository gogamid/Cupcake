package com.example.cupcake.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {
  private val _quantity = MutableLiveData(0)
  val quantity: LiveData<Int> = _quantity

  private val _flavor = MutableLiveData("")
  val flavor: LiveData<String> = _flavor

  private val _date = MutableLiveData("")
  val date: LiveData<String> = _date

  private val _price = MutableLiveData(0.0)
  val price: LiveData<Double> = _price

  fun setQuantity(quantity: Int) {
    _quantity.value = quantity
  }

  fun setFlavor(flavor: String) {
    _flavor.value = flavor
    Log.d("test", "Flavor has been set to ${_flavor.value}")
  }

  fun setDate(date: String) {
    _date.value = date
  }

  fun hasNoFlavorSet(): Boolean {
    return _flavor.value.isNullOrEmpty()
  }
}