package com.call.p1_ap2_carloslopez_20190720.ui.theme.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.call.p1_ap2_carloslopez_20190720.view.PrestamoViewModel

@Composable
fun PrestamoRegistroScreen(backToListado:() -> Unit, viewModel: PrestamoViewModel = hiltViewModel()){
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Prestamos") })
        }
    ) {it
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {

            OutlinedTextField(
                value = viewModel.deudor,
                onValueChange = {viewModel.deudor = it},
                label = { Text(text = "Deudor")},
                modifier = Modifier.fillMaxWidth()
                )

            OutlinedTextField(
                value = viewModel.concepto,
                onValueChange = {viewModel.concepto = it},
                label = { Text(text = "Concepto")},
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = viewModel.monto,
                onValueChange = {viewModel.monto = it},
                label = { Text(text = "Monto")},
                modifier = Modifier.fillMaxWidth()
            )

            Button(onClick = {
                viewModel.Guardar()
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