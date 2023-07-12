package com.ironsource.bootcounter.data.db

import android.content.Context
import androidx.room.Room
import com.ironsource.bootcounter.data.model.BootTime

class DatabaseManager(context: Context) {

    private val db by lazy {
        Room.databaseBuilder(context, AppDatabase::class.java, "database-name").build()
    }

    fun saveBootRecord() {
        val bootTime = BootTime(System.currentTimeMillis())
        db.bootTimeDao().insertAll(bootTime)
    }

    fun getRecords() = db.bootTimeDao().getAll()

}