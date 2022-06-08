package com.call.p1_ap2_carloslopez_20190720

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.call.p1_ap2_carloslopez_20190720.ui.theme.P1AP2CarlosLopez20190720Theme
import com.call.p1_ap2_carloslopez_20190720.ui.theme.componentes.PrestamoListaScreen
import com.call.p1_ap2_carloslopez_20190720.ui.theme.componentes.PrestamoRegistroScreen
import com.call.p1_ap2_carloslopez_20190720.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           myApp()
        }
    }
}

@Composable
fun myApp() {
    P1AP2CarlosLopez20190720Theme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navHostController = rememberNavController()
            NavHost(navController = navHostController,
                startDestination = Screen.prestamoListadoScreen.route){

                composable(route = Screen.prestamoListadoScreen.route){
                    PrestamoListaScreen(goToRegistro = {navHostController.navigate(Screen.prestamoRegistroScreen.route)})
                }

                composable(route = Screen.prestamoRegistroScreen.route){
                    PrestamoRegistroScreen(backToListado = {navHostController.navigate(Screen.prestamoListadoScreen.route)})
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    P1AP2CarlosLopez20190720Theme {
        myApp()
    }
}