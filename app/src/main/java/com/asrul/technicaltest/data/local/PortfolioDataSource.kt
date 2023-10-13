package com.asrul.technicaltest.data.local

import android.content.Context
import com.asrul.technicaltest.R
import com.asrul.technicaltest.data.local.model.DonutChart
import com.asrul.technicaltest.data.local.model.LineChart
import com.asrul.technicaltest.domain.model.Portfolio
import com.google.gson.Gson

class PortfolioDataSource(
    private val context: Context
) {
    fun getPortfolioData(): Portfolio {
        val portfolioData = Portfolio()
        val jsonString = context.resources.openRawResource(R.raw.portfolio)
            .bufferedReader()
            .use { it.readText() }
        val portfolioResponse: List<*>? = Gson().fromJson(jsonString, List::class.java)

        if (portfolioResponse != null) {
            for (portfolio in portfolioResponse) {
                val portfolioJson = Gson().toJson(portfolio)
                when (portfolio) {
                    is Map<*, *> -> when (portfolio["type"] as String) {
                        "donutChart" -> {
                            portfolioData.donutChart =
                                Gson().fromJson(portfolioJson, DonutChart::class.java)
                        }

                        "lineChart" -> {
                            portfolioData.lineChart =
                                Gson().fromJson(portfolioJson, LineChart::class.java)
                        }
                    }
                }
            }
        }
        return portfolioData
    }
}