package com.example.finalapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalapp.presentation.add.AddScreen
import com.example.finalapp.presentation.detail.DetailScreen
import com.example.finalapp.presentation.home.HomeScreen


@Composable
fun NavigationGraph(
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home,
    ) {
        composable<Screen.Home> {
            HomeScreen(navController)
        }
        composable<Screen.Detail> {
            DetailScreen(navController)
        }
        composable<Screen.Add> {
            AddScreen(navController)
        }
    }
}