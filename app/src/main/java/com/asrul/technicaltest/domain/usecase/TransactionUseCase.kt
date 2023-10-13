package com.asrul.technicaltest.domain.usecase

import com.asrul.technicaltest.data.Resource
import com.asrul.technicaltest.data.local.entity.TransactionEntity
import com.asrul.technicaltest.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionUseCase {
    fun getAllTransaction(): Flow<Resource<Map<String, List<Transaction>>>>
    fun insertTransaction(transaction: TransactionEntity): Flow<Resource<Boolean>>
}