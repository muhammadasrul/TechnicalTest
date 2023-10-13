package com.asrul.technicaltest.data.local.model


import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

private const val uniqueValue = "w4lah"

data class Transaction(
    @SerializedName("data")
    var detailList: List<TransactionDetail>,
    @SerializedName("label")
    val label: String,
    @SerializedName("percentage")
    val percentage: String
)

fun Transaction.toJsonString(): String {
    return Gson().toJson(this).replace("/", uniqueValue)
}

fun String.toTransactionDTO(): Transaction {
    return Gson().fromJson(this.replace(uniqueValue, "/"), Transaction::class.java)
}