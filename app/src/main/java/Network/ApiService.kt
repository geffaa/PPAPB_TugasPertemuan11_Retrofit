package com.example.ppapb_tugaspertemuan11_retrofit.network


import com.example.ppapb_tugaspertemuan11_retrofit.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("assets")
    fun getCryptoData(): Call<ApiResponse>
}
