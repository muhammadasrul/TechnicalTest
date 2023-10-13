package com.asrul.technicaltest.data.remote.response


import com.google.gson.annotations.SerializedName

data class Small(
    @SerializedName("ext")
    val ext: String?,
    @SerializedName("hash")
    val hash: String?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("mime")
    val mime: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("path")
    val path: Any?,
    @SerializedName("size")
    val size: Double?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Int?
)