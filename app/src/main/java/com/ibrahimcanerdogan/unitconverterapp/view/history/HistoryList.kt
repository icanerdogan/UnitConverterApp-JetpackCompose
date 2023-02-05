package com.ibrahimcanerdogan.unitconverterapp.view.history

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.ibrahimcanerdogan.unitconverterapp.data.ConversionResult

@Composable
fun HistoryList(
    list: State<List<ConversionResult>>,
    onCloseTask : (ConversionResult) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(
            items = list.value,
            key = {item -> item.id}
        ) { item ->
            HistoryItem(messagePart1 = item.firstUnit, messagePart2 = item.secondUnit, onClose = { onCloseTask(item) })
        }
    }
}