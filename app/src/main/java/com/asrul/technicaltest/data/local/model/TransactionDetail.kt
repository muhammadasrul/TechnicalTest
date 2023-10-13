package com.asrul.technicaltest.data.local.model


import com.google.gson.annotations.SerializedName

data class TransactionDetail(
    @SerializedName("nominal")
    val nominal: Int,
    @SerializedName("trx_date")
    val trxDate: String
)