package com.call.p1_ap2_carloslopez_20190720.util

sealed class Screen(val route: String) {
    object RegistroScreen: Screen("RegistroScreen")
    object ListadoScreen: Screen("ListadoScreen")
}