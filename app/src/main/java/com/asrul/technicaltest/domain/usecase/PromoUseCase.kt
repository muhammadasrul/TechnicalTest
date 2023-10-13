package com.asrul.technicaltest.domain.usecase

import com.asrul.technicaltest.data.Resource
import com.asrul.technicaltest.data.remote.response.PromoResponse
import kotlinx.coroutines.flow.Flow

interface PromoUseCase {
    fun getPromoList(): Flow<Resource<PromoResponse>>
}