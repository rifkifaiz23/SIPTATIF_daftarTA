package com.example.daftarta

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class Email_sent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_sent)

        val back2LoginButton: Button = findViewById(R.id.back2login)
        back2LoginButton.setOnClickListener {
            val intent = Intent(this@Email_sent, MainActivity::class.java)
            startActivity(intent)
        }

        val resetPassButton: Button = findViewById(R.id.reset_pass)
        resetPassButton.setOnClickListener {
            val emailInputText = findViewById<TextInputEditText>(R.id.email)
            val email = emailInputText.text.toString()

            val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val savedEmail = sharedPref.getString("username", "")

            if (email == savedEmail) {
                // Email terdaftar, arahkan ke layout reset password
                val intent = Intent(this@Email_sent, Reset_pass::class.java)
                intent.putExtra("email", email) // Kirim email yang akan direset ke activity reset password
                startActivity(intent)
            } else {
                // Email tidak terdaftar
                Toast.makeText(this, "Email belum terdaftar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}