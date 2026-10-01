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
    Column(modifier = modifier) {
        Text(
            calculationFunc(0.00001).toString()
        )
    }
}

fun factorial(part: Int): Int {
    return if (part == 1)
        1
    else
        part*factorial(part-1)
}

fun calculationFunc(limit: Double): Triple<Double, Double, Int> {
    var result = 0.0
    var part = 1
    var count = 0
    var lastTerm = 0.0
    while (true){
        val term = (1.0/factorial(part))
        if (term < limit)
            break
        result+=term
        part+=2
        count++
        lastTerm = term
    }
    return Triple(result,lastTerm,count)
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    Lab4_CalculationTheme {
        ScreenOn()
    }
}