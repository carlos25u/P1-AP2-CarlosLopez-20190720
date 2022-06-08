package com.call.p1_ap2_carloslopez_20190720.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.call.p1_ap2_carloslopez_20190720.data.repository.PrestamoRepository
import com.call.p1_ap2_carloslopez_20190720.model.Prestamo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrestamoViewModel @Inject constructor(
    val prestamoRepository: PrestamoRepository
): ViewModel(){

    var deudor by mutableStateOf("")
    var concepto by mutableStateOf("")
    var monto by mutableStateOf("")

    var prestamos = prestamoRepository.getList()
        private set

    fun Guardar(){
        viewModelScope.launch {
            prestamoRepository.insertar(
                Prestamo(
                    deudor = deudor,
                    concepto = concepto,
                    monto = monto.toInt()
                )
            )
        }
    }
}