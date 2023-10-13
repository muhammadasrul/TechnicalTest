package com.asrul.technicaltest.ui.screen.portfolio

import android.graphics.Typeface
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.common.components.Legends
import co.yml.charts.common.model.PlotType
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.piechart.charts.DonutPieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData
import com.asrul.technicaltest.data.local.model.Transaction
import com.asrul.technicaltest.ui.component.LineChartView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioScreen(
    state: PortfolioState,
    goToDetailPortfolio: (Transaction) -> Unit,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Portfolio",
                        style = MaterialTheme.typography.headlineMedium,
                    )
                },
                navigationIcon = {
                    IconButton(onBackPressed) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Close",
                            tint = Color.Black
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Surface {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(horizontal = 24.dp)
            ) {
                if (state.lineChart.isNotEmpty()) {
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                        colors = CardDefaults.cardColors(containerColor = White)
                    ) {
                        LineChartView(state.lineChart)
                    }
                }

                if (state.donutChart.isNotEmpty()) {
                    val pieChartConfig =
                        PieChartConfig(
                            labelVisible = true,
                            strokeWidth = 120f,
                            labelColor = Color.Black,
                            activeSliceAlpha = .9f,
                            isEllipsizeEnabled = true,
                            labelTypeface = Typeface.defaultFromStyle(Typeface.BOLD),
                            isAnimationEnable = true,
                            chartPadding = 25,
                            labelFontSize = 42.sp,
                        )

                    Legends(
                        modifier = Modifier.padding(top = 18.dp),
                        legendsConfig = DataUtils.getLegendsConfigFromPieChartData(
                            pieChartData = PieChartData(state.donutChart, PlotType.Donut),
                            gridSize = 3
                        )
                    )
                    DonutPieChart(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp),
                        PieChartData(state.donutChart, PlotType.Donut),
                        pieChartConfig
                    ) { slice ->
                        val index = state.donutChart.indexOf(slice)
                        goToDetailPortfolio(state.transactionData[index])
                    }
                }
            }
        }
    }
}