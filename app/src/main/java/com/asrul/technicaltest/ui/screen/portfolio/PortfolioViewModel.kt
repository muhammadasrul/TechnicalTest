package com.asrul.technicaltest.ui.screen.portfolio

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.yml.charts.common.model.Point
import co.yml.charts.ui.piechart.models.PieChartData
import com.asrul.technicaltest.data.Resource
import com.asrul.technicaltest.data.local.model.Transaction
import com.asrul.technicaltest.domain.usecase.PortfolioUseCase
import com.asrul.technicaltest.ui.theme.AppBlueDark
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class PortfolioViewModel @Inject constructor(
    private val useCase: PortfolioUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PortfolioState())
    val state = _state.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            useCase.getPortfolio().collect { resource ->
                when (resource) {
                    is Resource.Error -> _state.update {
                        it.copy(
                            isLoading = false,
                            transactionData = emptyList(),
                            donutChart = emptyList(),
                            lineChart = emptyList(),
                            error = resource.message
                        )
                    }

                    is Resource.Loading -> _state.update {
                        it.copy(
                            isLoading = true,
                            transactionData = emptyList(),
                            donutChart = emptyList(),
                            lineChart = emptyList(),
                            error = ""
                        )
                    }

                    is Resource.Success -> {
                        val transactionData =
                            resource.data?.donutChart?.transactionList ?: emptyList()
                        val donutData = resource.data?.donutChart?.transactionList?.mapIndexed { i, data ->
                            PieChartData.Slice(
                                label = data.label,
                                value = data.percentage.toFloat(),
                                color = AppBlueDark.copy((i+1)/5f),
                                sliceDescription = { data.label }
                            )
                        } ?: emptyList()
                        val lineData = resource.data?.lineChart?.data?.month?.mapIndexed { index, i ->
                            val cal = Calendar.getInstance().apply {
                                set(Calendar.MONTH, index)
                            }
                            val month = SimpleDateFormat("MMM", Locale.getDefault())
                                .format(Date(cal.timeInMillis))

                            Point(index.toFloat(), i.toFloat(), month)
                        } ?: emptyList()

                        _state.update {
                            it.copy(
                                isLoading = false,
                                transactionData = transactionData,
                                donutChart = donutData,
                                lineChart = lineData,
                                error = ""
                            )
                        }
                    }
                }
            }
        }
    }
}

data class PortfolioState(
    val transactionData: List<Transaction> = emptyList(),
    val donutChart: List<PieChartData.Slice> = emptyList(),
    val lineChart: List<Point> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)