package com.example.ppapb_tugaspertemuan11_retrofit.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("data") val data: List<CryptoModel>
)
