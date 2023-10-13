package com.asrul.technicaltest.data.repository

import com.asrul.technicaltest.data.Resource
import com.asrul.technicaltest.data.datastore.UserDataStore
import com.asrul.technicaltest.data.local.dao.TransactionDao
import com.asrul.technicaltest.data.local.entity.TransactionEntity
import com.asrul.technicaltest.data.remote.ApiService
import com.asrul.technicaltest.data.remote.response.PromoResponse
import com.asrul.technicaltest.domain.model.Transaction
import com.asrul.technicaltest.domain.model.User
import com.asrul.technicaltest.domain.model.generateInitialUser
import com.asrul.technicaltest.domain.repository.Repository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dao: TransactionDao,
    private val dataStore: UserDataStore
) : Repository {
    override fun getAllTransaction(): Flow<Resource<Map<String, List<Transaction>>>> = flow {
        emit(Resource.Loading())
        delay(1000)
        try {
            val data = dao.getAllTransaction()
                .sortedByDescending { it.date }
                .map { it.toTransaction() }
            
            val group = data.groupBy { it.date }
            if (group.isEmpty()) {
                emit(Resource.Error("There is no transaction, yet"))
            } else {
                emit(Resource.Success(group))
            }
        } catch (e: IOException) {
            emit(Resource.Error(e.message ?: "An unexpected error occurred"))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occurred"))
        }
    }

    override fun insertTransaction(transaction: TransactionEntity): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        try {
            dao.insertTransaction(transaction)
            val balance = dataStore.user.first().currentBalance - transaction.transactionAmount
            dataStore.updateCurrentBalance(balance)
            emit(Resource.Success(true))
        } catch (e: IOException) {
            emit(Resource.Error(e.message ?: "An unexpected error occurred"))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occurred"))
        }
    }

    override fun getUser(): Flow<Resource<User>> = flow {
        emit(Resource.Loading())
        try {
            dataStore.user.catch {
                emit(Resource.Error(it.message ?: "An unexpected error occurred"))
            }.collect {
                emit(Resource.Success(it))
            }
        } catch (e: IOException) {
            emit(Resource.Error(e.message ?: "An unexpected error occurred"))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occurred"))
        }
    }

    override fun getIsFirstInstall(): Flow<Resource<Boolean>> = flow {
        dataStore.isFirstInstall.catch {
            emit(Resource.Error(it.message ?: "An unexpected error occurred"))
        }.collect {
            if (it) {
                dataStore.setUser(
                    generateInitialUser()
                )
            }
            emit(Resource.Success(it))
        }
    }

    override fun getPromoList(): Flow<Resource<PromoResponse>> = flow {
        emit(Resource.Loading())
        try {
            val data = apiService.getPromoList()
            emit(Resource.Success(data = data))
        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(e.message ?: "An unexpected error occurred"))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occurred"))
        }
    }

    override suspend fun setFirstInstall() = dataStore.setFirstInstall()
}