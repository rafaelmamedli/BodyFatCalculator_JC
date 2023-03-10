package com.example.bodyfatcalculatorjc

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bodyfatcalculatorjc.view.CalculatorTypes
import com.example.bodyfatcalculatorjc.view.ProCalculator
import com.example.bodyfatcalculatorjc.view.SimpleCalculator

@Composable
fun Navigation(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.toString() ) {
        composable(route = Screen.MainScreen.toString()) {
            CalculatorTypes(navController = navController)
        }
        composable(route = Screen.ProBFC.toString()) {
            ProCalculator(navController = navController)
        }
        composable(route = Screen.SimpleBFC.toString()) {
            SimpleCalculator(navController = navController)
        }

    }
}


