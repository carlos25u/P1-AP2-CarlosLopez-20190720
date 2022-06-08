package com.call.p1_ap2_carloslopez_20190720.util

sealed class Screen(val route: String) {
    object prestamoRegistroScreen: Screen("prestamoRegistroScreen")
    object prestamoListadoScreen: Screen("prestamoListadoScreen")
}