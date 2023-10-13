package com.asrul.technicaltest.domain.usecase

import com.asrul.technicaltest.data.Resource
import com.asrul.technicaltest.domain.model.Portfolio
import com.asrul.technicaltest.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PortfolioUseCaseInteractor @Inject constructor(private val repository: Repository): PortfolioUseCase {
    override fun getPortfolio(): Flow<Resource<Portfolio>> = repository.getPortfolioData()
}