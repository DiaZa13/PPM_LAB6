package com.example.ppm_4.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "guest_table")
data class Guest(
    @PrimaryKey(autoGenerate = true)  var Id: Int = 0,
    @ColumnInfo(name = "name") @NotNull val name: String,
    @ColumnInfo(name = "phone") @NotNull val phone: String,
    @ColumnInfo(name = "email") @NotNull val email: String,
    @ColumnInfo(name = "registered") var registered: String,
    @ColumnInfo(name = "role_id") val role_id: String
)

