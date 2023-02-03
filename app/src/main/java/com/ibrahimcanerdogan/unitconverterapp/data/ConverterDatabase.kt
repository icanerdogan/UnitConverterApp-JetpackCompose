package com.ibrahimcanerdogan.unitconverterapp.data

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ConversionResult::class],
    version = 2
)
abstract class ConverterDatabase() : RoomDatabase() {

    abstract val converterDAO : ConverterDAO
    companion object {
        @Volatile
        private var INSTANCE : ConverterDatabase? = null
        fun getInstance(context: Context) : ConverterDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ConverterDatabase::class.java,
                        "conversion_database"
                    ).build()
                }
                return instance
            }
        }
    }
}