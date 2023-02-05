package com.ibrahimcanerdogan.unitconverterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.ibrahimcanerdogan.unitconverterapp.data.ConverterDatabase
import com.ibrahimcanerdogan.unitconverterapp.data.ConverterRepositoryImpl
import com.ibrahimcanerdogan.unitconverterapp.ui.theme.UnitConverterAppTheme
import com.ibrahimcanerdogan.unitconverterapp.view.BaseScreen
import com.ibrahimcanerdogan.unitconverterapp.view.ConverterViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var factory : ConverterViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UnitConverterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BaseScreen(factory = factory)
                }
            }
        }
    }
}
