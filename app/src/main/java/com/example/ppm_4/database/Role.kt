package com.example.ppm_4.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "role_table")
data class Role(
    @ColumnInfo(name = "Id") var Id: Int = 0,
    @PrimaryKey @ColumnInfo(name = "name") @NotNull val name: String,
    @ColumnInfo(name = "description") @NotNull val description: String,
    @ColumnInfo(name = "order") @NotNull val oder: Int

)