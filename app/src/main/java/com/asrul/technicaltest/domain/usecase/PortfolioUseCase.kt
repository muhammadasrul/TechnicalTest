package com.asrul.technicaltest.domain.usecase

import com.asrul.technicaltest.data.Resource
import com.asrul.technicaltest.domain.model.Portfolio
import kotlinx.coroutines.flow.Flow

interface PortfolioUseCase {
    fun getPortfolio(): Flow<Resource<Portfolio>>
}