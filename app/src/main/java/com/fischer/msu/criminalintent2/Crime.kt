package com.fischer.msu.criminalintent2

import java.util.*

data class Crime (
    val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean
    )