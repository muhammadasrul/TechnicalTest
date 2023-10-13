package com.asrul.technicaltest.data.remote.response


import com.google.gson.annotations.SerializedName

data class Formats(
    @SerializedName("large")
    val large: Large?,
    @SerializedName("medium")
    val medium: Medium?,
    @SerializedName("small")
    val small: Small?,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?
)