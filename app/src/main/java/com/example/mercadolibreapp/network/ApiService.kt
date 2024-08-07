package com.example.mercadolibreapp.network

import com.example.mercadolibreapp.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("sites/MLA/search")
    suspend fun searchProducts(@Query("q") query: String): Response<ProductResponse>
}
