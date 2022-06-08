package com.call.p1_ap2_carloslopez_20190720.data.repository

import com.call.p1_ap2_carloslopez_20190720.data.PrestamoDao
import com.call.p1_ap2_carloslopez_20190720.model.Prestamo
import kotlinx.coroutines.flow.Flow
import java.sql.RowId
import javax.inject.Inject

class PrestamoRepository @Inject constructor(
    val prestamoDao: PrestamoDao
){
    suspend fun insertar(prestamo: Prestamo){
        prestamoDao.insertar(prestamo)
    }

    suspend fun eliminar(prestamo: Prestamo){
        prestamoDao.eliminar(prestamo)
    }

    fun buscar(prestamoId: Int): Flow<Prestamo> {
        return prestamoDao.buscar(prestamoId)
    }

    fun getList(): Flow<List<Prestamo>> {
        return prestamoDao.getList()
    }
}