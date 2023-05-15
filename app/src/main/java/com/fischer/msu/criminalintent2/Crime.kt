package com.fischer.msu.criminalintent2

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Crime(
    @PrimaryKey val id: UUID,
    var title: String,
    var date: Date,
    var isSolved: Boolean,
    var requiresPolice: Boolean
)
