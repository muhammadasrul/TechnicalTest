package com.asrul.technicaltest.util

import com.asrul.technicaltest.domain.model.QrResult
import org.junit.Assert.*

import org.junit.Test

class ExtFunctionKtTest {

    @Test
    fun toRupiahFormat() {
        val nominal = 2000000.0
        val result = "Rp 2.000.000,00"
        assertEquals(nominal.toRupiahFormat(), result)
    }

    @Test
    fun toQrResultDTO() {
        val qrString = "BNI.ID12345678.MERCHANT MOCK TEST.50000"
        val id = "ID12345678"
        val sof = "BNI"
        val merchant = "MERCHANT MOCK TEST"
        val nominal = "50000"

        val qrResult = QrResult(
            transactionId = id,
            sof = sof,
            merchant = merchant,
            transactionAmount = nominal
        )

        assertEquals(qrString.toQrResultDTO(), qrResult)
    }

    @Test
    fun toFormattedDate() {
        val timeStamp = 1691051973000
        val result = "03 Aug 2023"
        assertEquals(timeStamp.toFormattedDate(), result)
    }

    @Test
    fun toDateFormat() {
        val nominal = "19/01/2023"
        val result = "19 Jan 2023"
        assertEquals(nominal.toDateFormat(), result)
    }
}