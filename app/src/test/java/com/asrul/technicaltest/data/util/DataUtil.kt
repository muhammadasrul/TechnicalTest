package com.asrul.technicaltest.data.util

import com.asrul.technicaltest.data.remote.response.PromoItem
import com.asrul.technicaltest.data.remote.response.PromoResponse

fun generatePromoData(): PromoResponse {
    val promo = PromoItem(
        alt = null,
        count = null,
        createdAt = null,
        createdAtDate = null,
        desc = null,
        descPromo = null,
        id = null,
        img = null,
        latitude = null,
        lokasi = null,
        longitude = null,
        nama = null,
        namePromo = null,
        publishedAt = null,
        title = null,
        updatedAt = null
    )
    return PromoResponse().apply { add(promo) }
}