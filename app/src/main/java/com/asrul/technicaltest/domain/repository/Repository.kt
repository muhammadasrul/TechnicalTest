package com.asrul.technicaltest.domain.repository

import com.asrul.technicaltest.data.Resource
import com.asrul.technicaltest.data.local.entity.TransactionEntity
import com.asrul.technicaltest.data.remote.response.PromoResponse
import com.asrul.technicaltest.domain.model.Portfolio
import com.asrul.technicaltest.domain.model.Transaction
import com.asrul.technicaltest.domain.model.User
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAllTransaction(): Flow<Resource<Map<String, List<Transaction>>>>
    fun insertTransaction(transaction: TransactionEntity): Flow<Resource<Boolean>>
    fun getUser(): Flow<Resource<User>>
    suspend fun setFirstInstall()
    fun getIsFirstInstall(): Flow<Resource<Boolean>>
    fun getPromoList(): Flow<Resource<PromoResponse>>
    fun getPortfolioData(): Flow<Resource<Portfolio>>
}