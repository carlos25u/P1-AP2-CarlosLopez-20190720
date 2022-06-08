package com.call.p1_ap2_carloslopez_20190720.ui.theme.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.call.p1_ap2_carloslopez_20190720.view.PrestamoViewModel

@Composable
fun PrestamoRegistroScreen(backToListado:() -> Unit, viewModel: PrestamoViewModel = hiltViewModel()){
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro") })
        }
    ) {it
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {

            Button(onClick = {
                             backToListado()
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ) {
                Text(text = "Guardar")
            }
        }
    }
}