package com.asrul.technicaltest.domain.usecase

import com.asrul.technicaltest.data.Resource
import com.asrul.technicaltest.data.remote.response.PromoResponse
import com.asrul.technicaltest.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PromoUseCaseInteractor @Inject constructor(private val repository: Repository) : PromoUseCase {
    override fun getPromoList(): Flow<Resource<PromoResponse>> = repository.getPromoList()
}