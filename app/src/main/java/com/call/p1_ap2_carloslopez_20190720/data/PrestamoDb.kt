package com.call.p1_ap2_carloslopez_20190720.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.call.p1_ap2_carloslopez_20190720.model.Prestamo

@Database(
    entities = [
        Prestamo::class],

    exportSchema = false,
    version = 1
)
abstract class PrestamoDb : RoomDatabase() {
    abstract val prestamoDao: PrestamoDao
}