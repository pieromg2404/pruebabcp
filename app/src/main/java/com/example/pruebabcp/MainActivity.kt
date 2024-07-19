package com.example.pruebabcp

import androidx.compose.material3.Surface
import com.example.pruebabcp.ui.theme.PruebabcpTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.example.pruebabcp.presentation.screen1.Screen1Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebabcpTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Screen1Screen()
                }
            }
        }
    }
}
