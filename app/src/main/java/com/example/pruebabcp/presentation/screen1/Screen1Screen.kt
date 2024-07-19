package com.example.pruebabcp.presentation.screen1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pruebabcp.analytics.AnalyticsManager

@Composable
fun Screen1Screen(viewModel: Screen1ViewModel = viewModel(),
                  analyticsManager: AnalyticsManager = viewModel()) {
    val devices by viewModel.devices.collectAsState()
    val error by viewModel.errorMessage.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Row (
           modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.SpaceAround
       ){
           Button(
               onClick = {
                   viewModel.loadDevices()
                   analyticsManager.trackEvent("Screen 1", mapOf("Action" to "Button 1 Click"))
               }
           ) {
               Text("B1")
           }
           Button(
               onClick = {
                   viewModel.loadDevices()
                   analyticsManager.trackEvent("Screen 2", mapOf("Action2" to "Button 2 Click"))
               }
           ) {
               Text("B2")
           }
           Button(
               onClick = {
                   viewModel.loadDevices()
                   analyticsManager.trackEvent("Screen 3", mapOf("Action3" to "Button 3 Click"))
               }
           ) {
               Text("B3")
           }
       }
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        error?.let {
            Text("Error: $it", color = Color.Red)
        }

        devices.forEach { device ->
            Text(text = device.name)
        }
    }
}

@Preview
@Composable
fun PreviewScreen1Screen() {
    Screen1Screen()
}

//@Composable
//fun AnalyticsScreen(analyticsManager: AnalyticsManager = viewModel()) {
//  Column (modifier = Modifier.background(color = Color.Black).fillMaxSize(),
//    verticalArrangement = Arrangement.SpaceAround,
//    horizontalAlignment = Alignment.CenterHorizontally
//    ){
//      Button(
//          onClick = {
//          analyticsManager.trackEvent("Screen 1", mapOf("Action" to "Button 1 Click"))
//      }) {
//           Text("Track Event 1", style = TextStyle(color = Color.White))
//       }
//        Button(
//            onClick = {
//            analyticsManager.trackEvent("Screen 2", mapOf("Action" to "Button 2 Click"))
//
//        }) {
//            Text("Track Event 2", style = TextStyle(color = Color.White))
//        }
//      Button(
//          onClick = {
//          analyticsManager.trackEvent("Screen 3", mapOf("Action" to "Button 3 Click"))
//
//      }) {
//          Text("Track Event 3", style = TextStyle(color = Color.White))
//      }
//    }
//}
