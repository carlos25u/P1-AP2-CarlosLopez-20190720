package com.call.p1_ap2_carloslopez_20190720.data

import androidx.room.*
import com.call.p1_ap2_carloslopez_20190720.model.Prestamo
import kotlinx.coroutines.flow.Flow

@Dao
interface ClienteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(prestamo: Prestamo)

    @Delete
    suspend fun eliminar(prestamo: Prestamo)

    @Query(
        """
        SELECT * 
        FROM Prestamos
        WHERE prestamoId=:prestamoId
    """
    )
    fun buscar(prestamoId: Int): Flow<Prestamo>

    @Query("""
        SELECT * 
        FROM Prestamos
        ORDER BY prestamoId    
    """)
    fun getList(): Flow<List<Prestamo>>
}