package com.example.ppm_4.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Defines methods for using the SleepNight class with Room.
 */
@Dao
interface SleepDatabaseDao {

    @Insert
    fun insert(guest: Guest)
    fun insert(role: Role)

    /**
     * When updating a row with a value already set in a column,
     * replaces the old value with the new one.
     *
     * @param guest new guest to write
     * @param role new role to add
     */
    @Update
    fun update(guest: Guest)
    fun update(role: Role)


    /**
     * Selects and returns all rows in the table,
     *
     * sorted by start time in ascending order.
     */
    @Query("SELECT * FROM guest_table ORDER BY Id ASC")
    fun getAllGuests(): LiveData<List<Guest>>

    @Query("SELECT * FROM role_table ORDER BY Id ASC")
    fun getAllRoles(): LiveData<List<Role>>

    /**
     * Selects and returns the first guest.
     */
    @Query("SELECT * FROM guest_table ORDER BY Id ASC LIMIT 1")
    fun getGuest(): Guest?

}

