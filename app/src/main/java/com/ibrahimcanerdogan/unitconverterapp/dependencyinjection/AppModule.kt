package com.ibrahimcanerdogan.unitconverterapp.dependencyinjection

import android.app.Application
import androidx.room.Room
import com.ibrahimcanerdogan.unitconverterapp.data.ConverterDatabase
import com.ibrahimcanerdogan.unitconverterapp.data.ConverterRepository
import com.ibrahimcanerdogan.unitconverterapp.data.ConverterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // for ConverterDatabase instance
    @Provides
    @Singleton
    fun provideConverterDatabase(app: Application) : ConverterDatabase {
        return Room.databaseBuilder(
            app,
            ConverterDatabase::class.java,
            "conversion_database"
        ).build()
    }

    // for ConverterRepositoryImpl
    @Provides
    @Singleton
    fun provideConverterRepository(converterDatabase: ConverterDatabase) : ConverterRepository {
        return ConverterRepositoryImpl(converterDatabase.converterDAO)
    }
}