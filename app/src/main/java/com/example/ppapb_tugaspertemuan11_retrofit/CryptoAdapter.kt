package com.example.ppapb_tugaspertemuan11_retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.ppapb_tugaspertemuan11_retrofit.model.CryptoModel

// Kelas adapter untuk menghubungkan data kripto dengan tampilan UI
class CryptoAdapter(private val context: Context, private val cryptoList: List<CryptoModel>) : BaseAdapter() {

    // Mendapatkan jumlah item dalam daftar
    override fun getCount(): Int {
        return cryptoList.size
    }

    // Mendapatkan item pada posisi tertentu
    override fun getItem(position: Int): Any {
        return cryptoList[position]
    }

    // Mendapatkan ID dari suatu posisi
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // Mengatur tampilan suatu item dalam daftar
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val holder: ViewHolder

        // Jika tampilan belum ada, inflate dari layout list_item_crypto
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_crypto, parent, false)
            holder = ViewHolder()
            holder.symbolTextView = view.findViewById(R.id.symbolTextView)
            holder.nameTextView = view.findViewById(R.id.nameTextView)
            holder.priceTextView = view.findViewById(R.id.priceTextView)
            holder.rankTextView = view.findViewById(R.id.rankTextView) // Tambahkan TextView untuk rank
            holder.explorerTextView = view.findViewById(R.id.explorerTextView) // Tambahkan TextView untuk explorer
            view.tag = holder
        } else {
            // Jika tampilan sudah ada, ambil ViewHolder dari tag tampilan
            holder = view.tag as ViewHolder
        }

        // Mendapatkan data kripto pada posisi tertentu
        val crypto = getItem(position) as CryptoModel
        // Menghubungkan data dengan elemen-elemen UI
        holder.symbolTextView.text = crypto.symbol
        holder.nameTextView.text = crypto.name
        holder.priceTextView.text = crypto.priceUsd
        holder.rankTextView.text = "#${crypto.rank}" // Menampilkan rank
        holder.explorerTextView.text = crypto.explorer // Menampilkan explorer

        return view!!
    }

    // Kelas ViewHolder untuk menyimpan referensi ke elemen-elemen UI dalam suatu item
    private class ViewHolder {
        lateinit var symbolTextView: TextView
        lateinit var nameTextView: TextView
        lateinit var priceTextView: TextView
        lateinit var rankTextView: TextView // Tambahkan TextView untuk rank
        lateinit var explorerTextView: TextView // Tambahkan TextView untuk explorer
    }
}
