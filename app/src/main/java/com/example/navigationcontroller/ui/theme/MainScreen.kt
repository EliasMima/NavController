package com.example.navigationcontroller.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationcontroller.Routes
import com.example.navigationcontroller.ScreenA
import com.example.navigationcontroller.ScreenB

@Composable

fun MainScreen(){
    val navController= rememberNavController()
    NavHost(navController=navController, startDestination = Routes.ScreenA) {
        composable(Routes.ScreenA)
        { ScreenA(navController) }
        composable(Routes.ScreenB)
        { ScreenB() }
    }
}