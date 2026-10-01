package com.example.lab4_calculation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab4_calculation.ui.theme.Lab4_CalculationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4_CalculationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScreenOn(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ScreenOn(modifier: Modifier = Modifier) {
    Column() {
        Text(Factorial(1).toString())
        Text(Factorial(2).toString())
        Text(Factorial(3).toString())
        Text(Factorial(4).toString())
    }
}

fun Factorial(part: Int): Int {
    return if (part == 1)
        1
    else
        part*Factorial(part-1)
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    Lab4_CalculationTheme {
        ScreenOn()
    }
}