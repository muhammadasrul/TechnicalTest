package com.asrul.technicaltest.data.local.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("month")
    var month: List<Int>
)