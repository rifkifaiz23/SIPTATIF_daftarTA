package com.example.daftarta

import AdapterMHSStatus
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daftarta.obj.MHS_Status

class Status_pendaftaran : AppCompatActivity(), AdapterMHSStatus.OnItemClickListener {

    override fun onItemClick(position: Int) {
        val intent: Intent = when {
            // Jika posisi adalah baris pertama dalam pola, buka Home
            position % 2 == 0 -> Intent(this, Status_diterima::class.java)
            // Jika bukan baris pertama dalam pola, buka MainActivity
            else -> Intent(this, Status_ditolak::class.java)
        }
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status_pendaftaran)

        // Button navigasi
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
            val intent = Intent(this, Dospem::class.java)
            startActivity(intent)
        }

        imageViewStatus.setOnClickListener {
            val intent = Intent(this, Status_pendaftaran::class.java)
            startActivity(intent)
        }

        // RecyclerView
        val recyclerViewUserList = findViewById<RecyclerView>(R.id.recyclerViewMovieList)
        recyclerViewUserList.layoutManager = LinearLayoutManager(this)
        recyclerViewUserList.adapter = AdapterMHSStatus(userList, this)
        (recyclerViewUserList.adapter as AdapterMHSStatus).notifyDataSetChanged()

    }

    private val userList = ArrayList<MHS_Status>().apply {
        add(MHS_Status("27/04/2024", "Age Scanner", "Selesai", "Lihat Detail"))
        add(MHS_Status("27/04/2024", "Rain Counter", "Selesai", "Lihat Detail"))
        add(MHS_Status("27/04/2024", "Polution Cleaner", "Selesai", "Lihat Detail"))
        add(MHS_Status("30/04/2024", "Face Register", "Selesai", "Lihat Detail"))
        add(MHS_Status("30/04/2024", "Quantum Physics", "Selesai", "Lihat Detail"))
    }


}