package com.fischer.msu.criminalintent2.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fischer.msu.criminalintent2.Crime

@Database(entities = [Crime::class], version = 1, exportSchema = false)
@TypeConverters(CrimeTypeConverters::class)

abstract class CrimeDatabase: RoomDatabase() {
    abstract fun crimeDao(): CrimeDao

}