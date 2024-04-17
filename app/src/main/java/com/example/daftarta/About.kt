package com.example.daftarta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val kembalimainButton: Button = findViewById(R.id.kembali)
        kembalimainButton.setOnClickListener {
            val intent = Intent(this@About, MainActivity::class.java)
            startActivity(intent)
        }
    }
}