package com.ibrahimcanerdogan.unitconverterapp.top

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.ibrahimcanerdogan.unitconverterapp.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TopScreen(list: List<Conversion>){

    val selectedConversion : MutableState<Conversion?> = remember { mutableStateOf(null) }
    val inputText : MutableState<String> = remember { mutableStateOf("") }
    val typedValue = remember { mutableStateOf("0.0") }

    ConversionMenu(list){
        selectedConversion.value = it
    }

    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inputText) {
            typedValue.value = it
        }
    }

    if (typedValue.value != "0.0") {
        val input = typedValue.value.toDouble()
        val multiply = selectedConversion.value!!.multiplyBy
        val result = input * multiply

        // round value
        val df = DecimalFormat("#.####")
        df.roundingMode = RoundingMode.DOWN
        val roundedResult = df.format(result)

        val convertFromText = "${typedValue.value} ${selectedConversion.value!!.convertFrom}"
        val convertToText = "$roundedResult ${selectedConversion.value!!.convertTo}"
        ResultBlock(convertFromText, convertToText)
    }
}