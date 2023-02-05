package com.ibrahimcanerdogan.unitconverterapp.view

import android.view.MenuItem
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimcanerdogan.unitconverterapp.data.Conversion
import com.ibrahimcanerdogan.unitconverterapp.data.ConversionResult
import com.ibrahimcanerdogan.unitconverterapp.data.ConverterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConverterViewModel(
    private val repository: ConverterRepository
) : ViewModel() {

    fun getConversions() = listOf(
        Conversion(1,"Pounds to Kilograms","LBS","KG",0.453592),
        Conversion(2,"Kilograms to Pounds","KG","LBS",2.20462),
        Conversion(3,"Yards to Meters","YD","M",0.9144),
        Conversion(4,"Meters to Yards","M","YD",1.09361),
        Conversion(5,"Miles to Kilometers","MI","KM",1.60934),
        Conversion(6,"Kilometers to Miles","KM","MI",0.621371)
    )

    val resultList = repository.getSavedResults()

    fun addResult(message1 : String, message2: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertResult(ConversionResult(0, message1, message2))
        }
    }

    fun removeResult(item: ConversionResult) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteResult(item)
        }
    }

    fun clearAllResults() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllResults()
        }
    }
}