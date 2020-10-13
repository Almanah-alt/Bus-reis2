package com.example.busfleets.trainSchedule


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.selects.select

@Dao
interface PassengerDao {

    @Insert
    fun insertPassenger(passenger: BussPassenger)

    @Query("Select * FROM passengers")
    fun getPassenger(): List<BussPassenger>

    @Delete
    fun deleteItem(passenger: BussPassenger)

}