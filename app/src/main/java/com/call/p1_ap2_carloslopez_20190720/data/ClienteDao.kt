package com.call.p1_ap2_carloslopez_20190720.data

import androidx.room.*
import com.call.p1_ap2_carloslopez_20190720.model.Cliente
import kotlinx.coroutines.flow.Flow

@Dao
interface ClienteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(cliente: Cliente)

    @Delete
    suspend fun eliminar(cliente: Cliente)

    @Query(
        """
        SELECT * 
        FROM Clientes
        WHERE clienteId=:clienteId
    """
    )
    fun buscar(clienteId: Int): Flow<Cliente>

    @Query("""
        SELECT * 
        FROM Clientes
        ORDER BY clienteId    
    """)
    fun getList(): Flow<List<Cliente>>
}