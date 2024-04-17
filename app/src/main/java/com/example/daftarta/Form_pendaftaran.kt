package com.example.daftarta

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Form_pendaftaran : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_pendaftaran)

        //button aksi
        val buttonKirim = findViewById<Button>(R.id.kirim)
        val buttonBatal = findViewById<Button>(R.id.batal)

        buttonKirim.setOnClickListener {
            val intent = Intent(this, Data_pendaftaran::class.java)
            startActivity(intent)
        }

        buttonBatal.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val chooseFileButton: Button = findViewById(R.id.choosefile)

        chooseFileButton.setOnClickListener {
            openGallery()
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
    }

    private fun openGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            val uri = data.data
        }
    }
}