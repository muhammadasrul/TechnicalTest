package com.asrul.technicaltest.ui.screen.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asrul.technicaltest.data.Resource
import com.asrul.technicaltest.domain.model.Transaction
import com.asrul.technicaltest.domain.usecase.TransactionUseCase
import com.asrul.technicaltest.util.toFormattedDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class TransactionHistoryViewModel @Inject constructor(
    private val transactionUseCase: TransactionUseCase
): ViewModel() {

    private val _transactionState: MutableStateFlow<TransactionHistoryState> = MutableStateFlow(
        TransactionHistoryState()
    )
    val transactionState = _transactionState.asStateFlow()

    init {
        getTransactionHistory()
    }

    private fun getTransactionHistory() {
        viewModelScope.launch {
            transactionUseCase.getAllTransaction().collect { resource ->
                when (resource) {
                    is Resource.Error -> _transactionState.update { it.copy(isLoading = false, error = resource.message) }
                    is Resource.Loading -> _transactionState.update { it.copy(isLoading = true, error = "") }
                    is Resource.Success -> _transactionState.update {
                        val date = Date().time.toFormattedDate()

                        var used = 0.0
                        resource.data?.get(date)?.forEach { transaction ->
                            used+=transaction.transactionAmount
                        }

                        it.copy(isLoading = false, error = "", data = resource.data ?: emptyMap(), usedInMonth = used)
                    }
                }
            }
        }
    }
}

data class TransactionHistoryState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: Map<String, List<Transaction>> = emptyMap(),
    val usedInMonth: Double = 0.0
)