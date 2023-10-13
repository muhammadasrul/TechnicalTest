package com.asrul.technicaltest.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.asrul.technicaltest.domain.model.Transaction
import com.asrul.technicaltest.util.toFormattedDate

@Entity(tableName = "transaction")
data class TransactionEntity(
    @PrimaryKey val transactionId: String,
    val merchant: String,
    val transactionAmount: Double,
    val date: Long
) {
    fun toTransaction(): Transaction {
        return Transaction(
            transactionId = transactionId,
            merchant = merchant,
            transactionAmount = transactionAmount,
            date = date.toFormattedDate()
        )
    }
}