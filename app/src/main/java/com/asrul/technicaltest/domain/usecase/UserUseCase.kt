package com.asrul.technicaltest.domain.usecase

import com.asrul.technicaltest.data.Resource
import com.asrul.technicaltest.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserUseCase {
    suspend fun setFirstInstall()
    fun isFirstInstall(): Flow<Resource<Boolean>>
    fun getUser(): Flow<Resource<User>>
}