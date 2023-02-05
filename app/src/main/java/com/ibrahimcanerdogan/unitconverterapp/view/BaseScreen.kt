package com.ibrahimcanerdogan.unitconverterapp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ibrahimcanerdogan.unitconverterapp.view.history.HistoryScreen
import com.ibrahimcanerdogan.unitconverterapp.view.top.TopScreen

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel(factory = factory)
) {
    val conversionList = converterViewModel.getConversions()
    val historyList = converterViewModel.resultList.collectAsState(initial = emptyList())

    Column(modifier = modifier.padding(30.dp)) {
        TopScreen(conversionList) { convertFromText, convertToText ->
            converterViewModel.addResult(convertFromText, convertToText)
        }
        Spacer(modifier = modifier.height(20.dp))
        HistoryScreen(
            historyList,
            { item -> converterViewModel.removeResult(item) },
            { converterViewModel.clearAllResults() }
        )
    }
}