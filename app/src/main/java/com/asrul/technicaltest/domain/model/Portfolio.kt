package com.asrul.technicaltest.domain.model

import com.asrul.technicaltest.data.local.model.DonutChart
import com.asrul.technicaltest.data.local.model.LineChart

data class Portfolio(
    var donutChart: DonutChart? = null,
    var lineChart: LineChart? = null
)
