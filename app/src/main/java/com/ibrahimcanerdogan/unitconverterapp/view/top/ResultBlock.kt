package com.ibrahimcanerdogan.unitconverterapp.view.top

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultBlock(
    convertFromText: String,
    convertToText: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Card(
            elevation = 20.dp,
            modifier = modifier.padding(0.dp, 20.dp, 0.dp, 0.dp)
        ) {
            Column(
                modifier = modifier.padding(10.dp)
            ) {
                Text(
                    text = convertFromText,
                    fontSize = 28.sp,
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = convertToText,
                    fontSize = 28.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}