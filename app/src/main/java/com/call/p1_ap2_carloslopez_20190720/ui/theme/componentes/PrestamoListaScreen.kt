package com.call.p1_ap2_carloslopez_20190720.ui.theme.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.call.p1_ap2_carloslopez_20190720.view.PrestamoViewModel

@Composable
fun PrestamoListaScreen(goToRegistro:() -> Unit, viewModel: PrestamoViewModel = hiltViewModel()){
    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar ={
            TopAppBar(title = { Text(text = "Listado de Prestamo") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                          goToRegistro()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Nuevo")
            }
        },
        scaffoldState = ScaffoldState
    ){it

        val listaPrestamo = viewModel.prestamos.collectAsState(initial = emptyList())

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ){
            items(listaPrestamo.value){ prestamos ->
                Row() {
                    Text(text = "${prestamos.prestamoId}\t\t\t" +
                            "${prestamos.deudor}\t\t\t"+
                            "${prestamos.concepto}\t\t\t"+
                            "${prestamos.monto}"
                    )
                }
            }
        }
    }
}