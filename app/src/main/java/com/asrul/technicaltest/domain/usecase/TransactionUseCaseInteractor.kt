package com.asrul.technicaltest.domain.usecase

import com.asrul.technicaltest.data.local.entity.TransactionEntity
import com.asrul.technicaltest.domain.repository.Repository
import javax.inject.Inject

class TransactionUseCaseInteractor @Inject constructor(private val repository: Repository):
    TransactionUseCase {
    override fun getAllTransaction() = repository.getAllTransaction()
    override fun insertTransaction(transaction: TransactionEntity) = repository.insertTransaction(transaction)
}