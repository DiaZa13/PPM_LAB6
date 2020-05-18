package com.example.ppm_4.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "role_table")
data class Role(
    var Id: Int = 0,
    @PrimaryKey @NotNull val name: String,
    @NotNull val description: String,
    @NotNull val order: Int



)