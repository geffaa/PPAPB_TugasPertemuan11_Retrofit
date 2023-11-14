package com.example.ppapb_tugaspertemuan11_retrofit.model

import com.google.gson.annotations.SerializedName

data class CryptoModel(
    @SerializedName("symbol") val symbol: String,
    @SerializedName("name") val name: String,
    @SerializedName("priceUsd") val priceUsd: String,
    @SerializedName("rank") val rank: String,
    @SerializedName("explorer") val explorer: String
)
