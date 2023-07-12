package com.ironsource.bootcounter.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ironsource.bootcounter.data.model.BootTime

@Dao
interface BootTimeDao {

    @Query("SELECT * FROM boottime")
    fun getAll(): List<BootTime>

    @Insert
    fun insertAll(vararg users: BootTime)

}