package com.example.finalapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.finalapp.navigation.NavigationGraph
import com.example.finalapp.ui.theme.AppBackgroundBrush
import com.example.finalapp.ui.theme.MyappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyappTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(AppBackgroundBrush)
                ) {
                NavigationGraph()}
            }
        }
    }
}