package com.asrul.technicaltest.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asrul.technicaltest.data.local.dao.TransactionDao
import com.asrul.technicaltest.data.local.entity.TransactionEntity

@Database(entities = [TransactionEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
}