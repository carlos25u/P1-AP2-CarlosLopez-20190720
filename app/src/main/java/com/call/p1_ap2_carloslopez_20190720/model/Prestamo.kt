package com.call.p1_ap2_carloslopez_20190720.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Prestamos")
data class Cliente(
    @PrimaryKey(autoGenerate = true)
    val prestamoId: Int=0,
    val deudor: String,
    val concepto: String,
    val monto: Int = 0
)