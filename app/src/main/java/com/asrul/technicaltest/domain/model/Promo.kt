package com.asrul.technicaltest.domain.model

import com.google.gson.Gson

private const val uniqueValue = "w4duh"

data class Promo(
    val desc: String,
    val img: String,
    val nama: String,
)

fun Promo.toJsonString(): String {
    return Gson().toJson(this).replace("/", uniqueValue)
}

fun String.toPromoDTO(): Promo {
    return Gson().fromJson(this.replace(uniqueValue, "/"), Promo::class.java)
}
