package com.asrul.technicaltest.ui.screen.promo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asrul.technicaltest.data.Resource
import com.asrul.technicaltest.data.remote.response.toPromoDTO
import com.asrul.technicaltest.domain.model.Promo
import com.asrul.technicaltest.domain.usecase.PromoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PromoViewModel @Inject constructor(
    private val promoUseCase: PromoUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PromoState())
    val state = _state.asStateFlow()

    init {
        getPromoList()
    }

    private fun getPromoList() {
        viewModelScope.launch {
            promoUseCase.getPromoList().collect { resource ->
                when (resource) {
                    is Resource.Error -> _state.update {
                        it.copy(
                            error = resource.message,
                            isLoading = false,
                            data = listOf()
                        )
                    }

                    is Resource.Loading -> _state.update {
                        it.copy(
                            isLoading = true,
                            error = "",
                            data = listOf()
                        )
                    }

                    is Resource.Success -> _state.update {
                        it.copy(
                            data = resource.data?.toList()?.map { promo -> promo.toPromoDTO() }
                                ?: emptyList(),
                            isLoading = false,
                            error = "",
                        )
                    }
                }
            }
        }
    }
}

data class PromoState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<Promo> = emptyList()
)