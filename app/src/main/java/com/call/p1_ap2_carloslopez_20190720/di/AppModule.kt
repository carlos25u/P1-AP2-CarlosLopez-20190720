package com.call.p1_ap2_carloslopez_20190720.di

import android.content.Context
import androidx.room.Room
import com.call.p1_ap2_carloslopez_20190720.data.ClienteDao
import com.call.p1_ap2_carloslopez_20190720.data.ClienteDb
import com.call.p1_ap2_carloslopez_20190720.data.repository.ClienteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesClientesDb(@ApplicationContext context: Context):ClienteDb{
        return  Room.databaseBuilder(
            context,
            ClienteDb::class.java,
            "ClienteDb")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesClienteDao(clienteDb: ClienteDb): ClienteDao {
        return clienteDb.clienteDao
    }


    @Provides
    fun providesClienteRepository(clienteDao: ClienteDao): ClienteRepository {
        return  ClienteRepository(clienteDao)
    }
}