package com.example.ppm_4.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "guest_table")
data class Guest(
    @PrimaryKey(autoGenerate = true)  var Id: Int = 0,
    @NotNull val name: String,
    @NotNull val phone: String,
    @NotNull val email: String,
    @NotNull var registered: String = ""
    //@NotNull val role_id: String
)

