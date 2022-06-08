package com.call.p1_ap2_carloslopez_20190720.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.call.p1_ap2_carloslopez_20190720.data.repository.ClienteRepository
import com.call.p1_ap2_carloslopez_20190720.model.Cliente
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClienteViewModel @Inject constructor(
    val clienteRepository: ClienteRepository
): ViewModel(){

    //var nombre by mutableStateOf("")

    var clientes = clienteRepository.getList()
        private set

    fun Guardar(){
        viewModelScope.launch {
            clienteRepository.insertar(
                Cliente(

                )
            )
        }
    }
}