package com.example.bodyfatcalculatorjc

sealed class Screen (val route: String){
    object MainScreen : Screen("main_screen")
    object ProBFC : Screen("pro_bfc")
}