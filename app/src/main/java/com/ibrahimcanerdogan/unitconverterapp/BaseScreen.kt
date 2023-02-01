package com.ibrahimcanerdogan.unitconverterapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ibrahimcanerdogan.unitconverterapp.history.HistoryScreen
import com.ibrahimcanerdogan.unitconverterapp.top.TopScreen

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    converterViewModel : ConverterViewModel = viewModel()
) {
    val conversionList = converterViewModel.getConversions()

    Column(modifier = modifier.padding(30.dp)) {
        TopScreen(conversionList)
        Spacer(modifier = modifier.height(20.dp))
        HistoryScreen()
    }
}