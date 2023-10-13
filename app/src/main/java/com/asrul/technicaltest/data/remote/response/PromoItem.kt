package com.asrul.technicaltest.data.remote.response


import com.asrul.technicaltest.domain.model.Promo
import com.google.gson.annotations.SerializedName

data class PromoItem(
    @SerializedName("alt")
    val alt: String?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("createdAt")
    val createdAtDate: String?,
    @SerializedName("desc")
    val desc: String?,
    @SerializedName("desc_promo")
    val descPromo: Any?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("img")
    val img: Img?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("lokasi")
    val lokasi: String?,
    @SerializedName("longitude")
    val longitude: String?,
    @SerializedName("nama")
    val nama: String?,
    @SerializedName("name_promo")
    val namePromo: Any?,
    @SerializedName("published_at")
    val publishedAt: String?,
    @SerializedName("Title")
    val title: Any?,
    @SerializedName("updated_at")
    val updatedAt: String?
)

fun PromoItem.toPromoDTO(): Promo {
    return Promo(
        desc = desc.orEmpty().ifEmpty { "-" },
        img = img?.formats?.medium?.url.orEmpty(),
        nama = nama.orEmpty().ifEmpty { "-" }
    )
}