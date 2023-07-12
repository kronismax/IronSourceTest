package com.ironsource.bootcounter.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ironsource.bootcounter.data.db.dao.BootTimeDao
import com.ironsource.bootcounter.data.model.BootTime

@Database(entities = [BootTime::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bootTimeDao(): BootTimeDao
}