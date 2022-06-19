package com.call.p1_ap2_carloslopez_20190720.ui.theme.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.call.p1_ap2_carloslopez_20190720.model.Prestamo
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
            modifier = Modifier.fillMaxWidth(),
        ){
            items(listaPrestamo.value){ prestamos ->
                Column(modifier = Modifier.fillMaxWidth())
                {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp).padding(vertical = 2.dp),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "${prestamos.deudor}")
                        
                        Text(text = "$${prestamos.monto}",
                            style = MaterialTheme.typography.h5)
                    }

                    Row( modifier = Modifier.fillMaxWidth().padding(vertical = 1.dp),
                        horizontalArrangement = Arrangement.Start){
                        Text(text = "${prestamos.concepto}",
                            style = MaterialTheme.typography.caption)
                    }
                }
            }
        }
    }
}