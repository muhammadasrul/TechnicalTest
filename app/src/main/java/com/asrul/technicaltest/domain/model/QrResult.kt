package com.asrul.technicaltest.domain.model

data class QrResult(
    val transactionId: String,
    val sof: String,
    val merchant: String,
    val transactionAmount: String
)