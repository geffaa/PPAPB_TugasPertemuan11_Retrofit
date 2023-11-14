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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listView = binding.listView

        fetchData()
    }

    private fun fetchData() {
        val apiService = ApiClient.getInstance().getCryptoData()

        apiService.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val cryptoList: List<CryptoModel>? = response.body()?.data
                    if (cryptoList != null) {
                        val adapter = CryptoAdapter(this@MainActivity, cryptoList)
                        listView.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                  t.printStackTrace()
            }
        })
    }
}
