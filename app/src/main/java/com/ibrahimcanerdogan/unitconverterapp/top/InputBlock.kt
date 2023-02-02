package com.ibrahimcanerdogan.unitconverterapp.top

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrahimcanerdogan.unitconverterapp.Conversion

@Composable
fun InputBlock(
    conversion: Conversion,
    inputText: MutableState<String>,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    calculate : (String) -> Unit
) {
    Column(
        modifier = modifier.padding(0.dp, 20.dp, 0.dp, 0.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = inputText.value,
                onValueChange = {
                    inputText.value = it
                },
                modifier = modifier.fillMaxWidth(0.60F),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.3F)
                ),
                textStyle = TextStyle(color = Color.DarkGray, fontSize = 30.sp),
                singleLine = true
            )
            Text(
                text = conversion.convertFrom,
                fontSize = 24.sp,
                modifier = modifier.padding(10.dp, 30.dp, 0.dp, 0.dp)
                    .fillMaxWidth(0.40F)
            )
        }
        Spacer(modifier = modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                if (inputText.value != "") calculate(inputText.value) else Toast.makeText(context, "Enter value!", Toast.LENGTH_LONG).show()
            },
            modifier = modifier.fillMaxWidth(1F)
        ){
            Text(
                text = "CONVERT",
                fontSize = 32.sp,
                fontWeight =  FontWeight.Bold,
                color = Color.Blue
            )
        }
    }
}