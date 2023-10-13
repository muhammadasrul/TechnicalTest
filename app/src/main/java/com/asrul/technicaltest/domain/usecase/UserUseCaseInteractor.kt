package com.asrul.technicaltest.domain.usecase

import com.asrul.technicaltest.data.Resource
import com.asrul.technicaltest.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserUseCaseInteractor @Inject constructor(private val repository: Repository): UserUseCase {
    override suspend fun setFirstInstall() = repository.setFirstInstall()
    override fun isFirstInstall(): Flow<Resource<Boolean>> = repository.getIsFirstInstall()
    override fun getUser() = repository.getUser()
}