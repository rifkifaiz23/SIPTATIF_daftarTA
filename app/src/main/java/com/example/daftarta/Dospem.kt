package com.example.daftarta

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daftarta.adapter.TableDospemAdapterr
import com.example.daftarta.obj.Dospem

class Dospem : AppCompatActivity() {

    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dospem)

        //button navigasi
        val imageViewBeranda = findViewById<ImageView>(R.id.beranda)
        val imageViewPendaftaran = findViewById<ImageView>(R.id.pendaftaran)
        val imageViewDospem = findViewById<ImageView>(R.id.dospem)
        val imageViewStatus = findViewById<ImageView>(R.id.status)

        imageViewBeranda.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        imageViewPendaftaran.setOnClickListener {
            val intent = Intent(this, Form_pendaftaran::class.java)
            startActivity(intent)
        }

        imageViewDospem.setOnClickListener {
            val intent = Intent(this, com.example.daftarta.Dospem::class.java)
            startActivity(intent)
        }

        imageViewStatus.setOnClickListener {
            val intent = Intent(this, Status_pendaftaran::class.java)
            startActivity(intent)
        }

        // Ambil referensi RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewDospem)

        // Inisialisasi data Dospem
        val dospemList = mutableListOf<Dospem>()
        // Tambahkan data Dospem ke dalam list
        dospemList.add(Dospem("1", "Budi Hartanto", "12345", "Laki-laki", "Programming", "10", "Detail"))
        dospemList.add(Dospem("2", "Siti Safira", "67890", "Perempuan", "Data Analysis", "8", "Detail"))
        dospemList.add(Dospem("3", "Edi Saputra", "23456", "Laki-laki", "Data Science", "12", "Detail"))
        dospemList.add(Dospem("4", "Cyntia Karnova", "78901", "Perempuan", "Data Mining", "9", "Detail"))

        // Inisialisasi adapter dengan data Dospem
        val adapter = TableDospemAdapterr(dospemList)

        // Atur layout manager untuk RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Tetapkan adapter untuk RecyclerView
        recyclerView.adapter = adapter

        // Inisialisasi SearchView
        searchView = findViewById(R.id.search)

        // Atur listener untuk SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter(newText.orEmpty())
                return true
            }
        })
    }

}
