package com.ibrahimcanerdogan.unitconverterapp

import androidx.lifecycle.ViewModel

class ConverterViewModel : ViewModel() {

    fun getConversions() = listOf(
        Conversion(1,"Pounds to Kilograms","LBS","KG",0.453592),
        Conversion(2,"Kilograms to Pounds","KG","LBS",2.20462),
        Conversion(3,"Yards to Meters","YD","M",0.9144),
        Conversion(4,"Meters to Yards","M","YD",1.09361),
        Conversion(5,"Miles to Kilometers","MI","KM",1.60934),
        Conversion(6,"Kilometers to Miles","KM","MI",0.621371)
    )
}