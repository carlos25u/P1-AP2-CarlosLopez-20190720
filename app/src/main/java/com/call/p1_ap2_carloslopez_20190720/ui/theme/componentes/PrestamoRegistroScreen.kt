package com.call.p1_ap2_carloslopez_20190720.ui.theme.componentes

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.SaveAs
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.call.p1_ap2_carloslopez_20190720.view.PrestamoViewModel

@Composable
fun PrestamoRegistroScreen(backToListado:() -> Unit, viewModel: PrestamoViewModel = hiltViewModel()){
    val ScaffoldState = rememberScaffoldState()
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Prestamos") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                    val montovalidar:Int = viewModel.monto.toInt()

                    if(montovalidar > 0){
                        viewModel.Guardar()
                        backToListado()
                    }else{
                        Toast.makeText(context, "El Monto debe de ser mayor a 0", Toast.LENGTH_SHORT).show()
                    }
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.SaveAs, contentDescription = "Guardar")
            }
        },
        scaffoldState = ScaffoldState
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
        }
    }
}
