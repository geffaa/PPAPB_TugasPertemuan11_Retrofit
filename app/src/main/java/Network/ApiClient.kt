package com.example.ppapb_tugaspertemuan11_retrofit.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    // Mendapatkan instance dari ApiService
    fun getInstance(): ApiService {
        // Membuat HttpLoggingInterceptor untuk melihat log HTTP
        val mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        // Membuat OkHttpClient dengan menambahkan HttpLoggingInterceptor
        val mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()

        // Membuat objek Retrofit untuk melakukan HTTP requests
        val builder = Retrofit.Builder()
            .baseUrl("https://api.coincap.io/v2/") // Mengatur base URL dari API
            .addConverterFactory(GsonConverterFactory.create()) // Menggunakan GsonConverter untuk mengonversi JSON ke objek Kotlin
            .client(mOkHttpClient) // Mengatur OkHttpClient yang telah dibuat sebelumnya

        // Membuat instance Retrofit
        val retrofit = builder.build()

        // Mengembalikan instance ApiService yang telah dibuat oleh Retrofit
        return retrofit.create(ApiService::class.java)
    }
}
