package com.call.p1_ap2_carloslopez_20190720.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Clientes")
data class Cliente(
    @PrimaryKey(autoGenerate = true)
    val clienteId: Int=0,
)