package com.asrul.technicaltest.data.remote

import com.asrul.technicaltest.data.remote.response.PromoResponse
import retrofit2.http.GET

interface ApiService {

    @GET("promos")
    suspend fun getPromoList(): PromoResponse
}