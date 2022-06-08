package com.call.p1_ap2_carloslopez_20190720.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.call.p1_ap2_carloslopez_20190720.model.Cliente

@Database(
    entities = [
        Cliente::class],

    exportSchema = false,
    version = 1
)
abstract class ClienteDb : RoomDatabase() {
    abstract val clienteDao: ClienteDao
}