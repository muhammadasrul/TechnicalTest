package com.asrul.technicaltest.ui.screen.qrscanner

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asrul.technicaltest.data.Resource
import com.asrul.technicaltest.data.local.entity.TransactionEntity
import com.asrul.technicaltest.domain.model.User
import com.asrul.technicaltest.domain.usecase.TransactionUseCase
import com.asrul.technicaltest.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QrScannerViewModel @Inject constructor(
    private val transactionUseCase: TransactionUseCase,
    private val userUseCase: UserUseCase
): ViewModel() {

    private val _state: MutableStateFlow<InsertTransactionState> = MutableStateFlow(
        InsertTransactionState()
    )
    val state = _state.asStateFlow()

    private val _userState: MutableStateFlow<UserState> = MutableStateFlow(UserState())
    val userState = _userState.asStateFlow()

    init {
        getUser()
    }

    fun insertTransaction(transaction: TransactionEntity) {
        viewModelScope.launch {
            transactionUseCase.insertTransaction(transaction).collect { resource ->
                when (resource) {
                    is Resource.Error -> _state.update { it.copy(isLoading = false, isSuccess = false, error = resource.message) }
                    is Resource.Loading -> _state.update { it.copy(isLoading = true, isSuccess = false, error = "") }
                    is Resource.Success -> _state.update { it.copy(isLoading = false, isSuccess = true, error = "", data = transaction) }
                }
            }
        }
    }

    private fun getUser() {
        viewModelScope.launch {
            userUseCase.getUser().collect { resource ->
                when (resource) {
                    is Resource.Error -> _userState.update { it.copy(isLoading = false, error = resource.message, data = null) }
                    is Resource.Loading -> _userState.update { it.copy(isLoading = true, error = "", data = null) }
                    is Resource.Success -> _userState.update { it.copy(isLoading = false, error = "", data = resource.data) }
                }
            }
        }
    }

    fun onHandled() {
        _state.update { it.copy(isLoading = false, isSuccess = false, error = "", data = null) }
    }
}

data class InsertTransactionState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String = "",
    val data: TransactionEntity? = null
)

data class UserState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: User? = null
)