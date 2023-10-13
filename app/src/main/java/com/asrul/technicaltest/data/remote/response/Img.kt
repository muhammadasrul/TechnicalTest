package com.asrul.technicaltest.data.remote.response


import com.google.gson.annotations.SerializedName

data class Img(
    @SerializedName("alternativeText")
    val alternativeText: String?,
    @SerializedName("caption")
    val caption: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("ext")
    val ext: String?,
    @SerializedName("formats")
    val formats: Formats?,
    @SerializedName("hash")
    val hash: String?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("mime")
    val mime: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("previewUrl")
    val previewUrl: Any?,
    @SerializedName("provider")
    val provider: String?,
    @SerializedName("provider_metadata")
    val providerMetadata: Any?,
    @SerializedName("size")
    val size: Double?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Int?
)