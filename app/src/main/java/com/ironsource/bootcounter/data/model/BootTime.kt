package com.ironsource.bootcounter.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BootTime(@PrimaryKey val timestamp: Long)