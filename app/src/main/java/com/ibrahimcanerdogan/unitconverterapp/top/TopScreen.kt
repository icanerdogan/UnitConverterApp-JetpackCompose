package com.ibrahimcanerdogan.unitconverterapp.top

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.ibrahimcanerdogan.unitconverterapp.Conversion

@Composable
fun TopScreen(list: List<Conversion>){
    ConversionMenu(list)

}