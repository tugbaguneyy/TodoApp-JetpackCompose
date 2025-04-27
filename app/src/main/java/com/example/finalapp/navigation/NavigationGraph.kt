package com.example.finalapp.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalapp.presentation.home.HomeScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationGraph(
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home,
    ) {
        composable<Screen.Home> {
            HomeScreen()
        }
    }
}