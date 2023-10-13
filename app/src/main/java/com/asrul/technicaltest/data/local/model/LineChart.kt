package com.asrul.technicaltest.data.local.model

import com.google.gson.annotations.SerializedName

data class LineChart(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("type")
    val type: String
)