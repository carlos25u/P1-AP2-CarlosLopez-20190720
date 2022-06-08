package com.call.p1_ap2_carloslopez_20190720.data.repository

import com.call.p1_ap2_carloslopez_20190720.data.ClienteDao
import com.call.p1_ap2_carloslopez_20190720.model.Cliente
import kotlinx.coroutines.flow.Flow
import java.sql.RowId
import javax.inject.Inject

class ClienteRepository @Inject constructor(
    val clienteDao: ClienteDao
){
    suspend fun insertar(cliente: Cliente){
        clienteDao.insertar(cliente)
    }

    suspend fun eliminar(cliente: Cliente){
        clienteDao.eliminar(cliente)
    }

    fun buscar(clienteId: Int): Flow<Cliente> {
        return   clienteDao.buscar(clienteId)
    }

    fun getList(): Flow<List<Cliente>> {
        return  clienteDao.getList()
    }
}