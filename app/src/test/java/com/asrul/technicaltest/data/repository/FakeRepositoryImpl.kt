package com.asrul.technicaltest.data.repository

import com.asrul.technicaltest.data.Resource
import com.asrul.technicaltest.data.local.entity.TransactionEntity
import com.asrul.technicaltest.data.remote.response.PromoResponse
import com.asrul.technicaltest.data.util.generatePromoData
import com.asrul.technicaltest.domain.model.Portfolio
import com.asrul.technicaltest.domain.model.Transaction
import com.asrul.technicaltest.domain.model.User
import com.asrul.technicaltest.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRepositoryImpl : Repository {
    override fun getAllTransaction(): Flow<Resource<Map<String, List<Transaction>>>> {
        TODO("Not yet implemented")
    }

    override fun insertTransaction(transaction: TransactionEntity): Flow<Resource<Boolean>> {
        TODO("Not yet implemented")
    }

    override fun getUser(): Flow<Resource<User>> {
        TODO("Not yet implemented")
    }

    override suspend fun setFirstInstall() {
        TODO("Not yet implemented")
    }

    override fun getIsFirstInstall(): Flow<Resource<Boolean>> {
        TODO("Not yet implemented")
    }

    override fun getPromoList(): Flow<Resource<PromoResponse>> = flow {
        val dataPromo = generatePromoData()

        emit(Resource.Success(dataPromo))
    }

    override fun getPortfolioData(): Flow<Resource<Portfolio>> {
        TODO("Not yet implemented")
    }
}