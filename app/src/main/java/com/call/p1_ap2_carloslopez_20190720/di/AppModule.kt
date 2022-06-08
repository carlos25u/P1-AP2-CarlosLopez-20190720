package com.call.p1_ap2_carloslopez_20190720.di

import android.content.Context
import androidx.room.Room
import com.call.p1_ap2_carloslopez_20190720.data.PrestamoDao
import com.call.p1_ap2_carloslopez_20190720.data.PrestamoDb
import com.call.p1_ap2_carloslopez_20190720.data.repository.PrestamoRepository
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
    fun providesClientesDb(@ApplicationContext context: Context):PrestamoDb{
        return  Room.databaseBuilder(
            context,
            PrestamoDb::class.java,
            "PrestamoDb")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesPrestamoDao(prestamoDb: PrestamoDb): PrestamoDao {
        return prestamoDb.prestamoDao
    }


    @Provides
    fun providesPrestamoRepository(prestamoDao: PrestamoDao): PrestamoRepository {
        return  PrestamoRepository(prestamoDao)
    }
}