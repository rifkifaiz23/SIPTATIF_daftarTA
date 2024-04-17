package com.example.daftarta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daftarta.adapter.TableViewAdapter
import com.example.daftarta.obj.Mahasiswa


class Data_pendaftaran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_pendaftaran)

        // button aksi
        val addButton: Button = findViewById(R.id.add)
        addButton.setOnClickListener {
            val intent = Intent(this@Data_pendaftaran, Form_pendaftaran::class.java)
            startActivity(intent)
        }

        val backButton: Button = findViewById(R.id.kembali)
        backButton.setOnClickListener {
            val intent = Intent(this@Data_pendaftaran, Form_pendaftaran::class.java)
            startActivity(intent)
        }

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
            val intent = Intent(this, Dospem::class.java)
            startActivity(intent)
        }

        imageViewStatus.setOnClickListener {
            val intent = Intent(this, Status_pendaftaran::class.java)
            startActivity(intent)
        }

        //RecyclerView
        val recyclerViewUserList = findViewById<RecyclerView>(R.id.recyclerViewMovieList)
        recyclerViewUserList.layoutManager = LinearLayoutManager(this)
        recyclerViewUserList.adapter = TableViewAdapter(userList)
    }

    private val userList = ArrayList<Mahasiswa>().apply {
        add(Mahasiswa("14-04-2024", "Age Scanner", "Selesai",))
        add(Mahasiswa("14-04-2024", "Rain Counter", "Selesai",))
        add(Mahasiswa("14-04-2240", "Polution Cleaner", "Selesai",))
        add(Mahasiswa("15-04-2024", "Face Register", "Selesai",))
        add(Mahasiswa("15-04-2024", "Quantum Physics", "Selesai",))
    }
}