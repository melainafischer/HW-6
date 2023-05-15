package com.fischer.msu.criminalintent2.database

import androidx.room.Query
import com.fischer.msu.criminalintent2.Crime
import kotlinx.coroutines.flow.Flow
import java.util.UUID

class CrimeDao {
    @Query("SELECT * FROM crime")
    fun getCrimes(): Flow<List<Crime>>

    @Query("SELECT * FROM crime WHERE id=(:id)")
    suspend fun getCrime(id: UUID): Crime
}
