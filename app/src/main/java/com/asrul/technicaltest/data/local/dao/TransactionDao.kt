package com.asrul.technicaltest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.asrul.technicaltest.data.local.entity.TransactionEntity

@Dao
interface TransactionDao {

    @Query("SELECT * FROM `transaction`")
    suspend fun getAllTransaction(): List<TransactionEntity>

    @Insert(TransactionEntity::class)
    suspend fun insertTransaction(transaction: TransactionEntity)
}