package com.example.ppapb_tugaspertemuan11_retrofit

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.ppapb_tugaspertemuan11_retrofit.databinding.ActivityMainBinding
import com.example.ppapb_tugaspertemuan11_retrofit.model.ApiResponse
import com.example.ppapb_tugaspertemuan11_retrofit.model.CryptoModel
import com.example.ppapb_tugaspertemuan11_retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menggunakan View Binding untuk mengakses elemen UI
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi ListView
        listView = binding.listView

        // Memanggil fungsi untuk mengambil dan menampilkan data kripto
        fetchData()
    }

    // Fungsi untuk mengambil data kripto dari API menggunakan Retrofit
    private fun fetchData() {
        // Mendapatkan instance dari ApiService yang telah dibuat di ApiClient
        val apiService = ApiClient.getInstance().getCryptoData()

        // Melakukan enqueue untuk melakukan asinkron request ke server
        apiService.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    // Mendapatkan list data kripto dari response
                    val cryptoList: List<CryptoModel>? = response.body()?.data
                    if (cryptoList != null) {
                        // Membuat adapter untuk ListView dan menghubungkannya dengan data kripto
                        val adapter = CryptoAdapter(this@MainActivity, cryptoList)
                        listView.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                // Menangani kegagalan koneksi atau request
                t.printStackTrace()
            }
        })
    }
}
