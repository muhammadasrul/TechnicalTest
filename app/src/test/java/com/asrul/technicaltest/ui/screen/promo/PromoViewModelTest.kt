package com.asrul.technicaltest.ui.screen.promo

import com.asrul.technicaltest.data.remote.response.toPromoDTO
import com.asrul.technicaltest.data.repository.FakeRepositoryImpl
import com.asrul.technicaltest.data.util.generatePromoData
import com.asrul.technicaltest.domain.usecase.PromoUseCase
import com.asrul.technicaltest.domain.usecase.PromoUseCaseInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PromoViewModelTest {

    private lateinit var promoViewModel: PromoViewModel
    private lateinit var promoUseCase: PromoUseCase

    private lateinit var repo: FakeRepositoryImpl

    @ExperimentalCoroutinesApi
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    @Before
    fun setupDispatcher() {
        Dispatchers.setMain(testDispatcher)
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDownDispatcher() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Before
    fun setUp() {
        repo = FakeRepositoryImpl()
        promoUseCase = PromoUseCaseInteractor(repo)

        promoViewModel = PromoViewModel(promoUseCase)
    }

    @Test
    fun getPromo() = runTest {
        promoViewModel.getPromoList()

        val data = generatePromoData().map { it.toPromoDTO() }

        assertEquals(promoViewModel.state.value, PromoState(
            isLoading = false,
            error = "",
            data = data
        ))
    }
}