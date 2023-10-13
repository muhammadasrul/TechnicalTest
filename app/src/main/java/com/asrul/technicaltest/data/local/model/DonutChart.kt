package com.asrul.technicaltest.data.local.model


import com.google.gson.annotations.SerializedName

data class DonutChart(
    @SerializedName("data")
    var transactionList: List<Transaction>,
    @SerializedName("type")
    val type: String
)