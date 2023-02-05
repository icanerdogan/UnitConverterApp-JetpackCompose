package com.ibrahimcanerdogan.unitconverterapp.view.convert

import androidx.compose.runtime.*
import com.ibrahimcanerdogan.unitconverterapp.data.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TopScreen(
    list: List<Conversion>,
    selectedConversion : MutableState<Conversion?>,
    inputText : MutableState<String>,
    typedValue : MutableState<String>,
    save : (String, String) -> Unit
) {

    // fix calculate when screen rotation.
    var toSave by remember { mutableStateOf(false) }

    ConversionMenu(list){
        selectedConversion.value = it
        typedValue.value = "0.0"
    }

    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inputText) {
            typedValue.value = it
            toSave = true
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

        if (toSave) {
            save(convertFromText, convertToText)
            toSave = false
        }

        ResultBlock(convertFromText, convertToText)
    }
}