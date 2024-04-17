package com.example.daftarta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

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

    }

}