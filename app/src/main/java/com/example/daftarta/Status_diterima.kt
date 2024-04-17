
package com.example.daftarta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Status_diterima : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status_diterima)

        val buttonKembali = findViewById<android.widget.Button>(R.id.kembali)

        buttonKembali.setOnClickListener {
            val intent = Intent(this, Status_pendaftaran::class.java)
            startActivity(intent)
        }
    }
}