package com.asrul.technicaltest.domain.model

data class Transaction(
    val transactionId: String,
    val merchant: String,
    val transactionAmount: Double,
    val date: String
)
