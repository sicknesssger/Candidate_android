package com.example.mercadolibreapp.repository

import com.example.mercadolibreapp.network.ApiService

class ProductRepository(private val apiService: ApiService) {
    suspend fun searchProducts(query: String) = apiService.searchProducts(query)
}
