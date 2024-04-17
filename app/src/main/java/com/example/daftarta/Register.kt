package com.example.daftarta

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val registerButton: Button = findViewById(R.id.register)
        registerButton.setOnClickListener {
            val emailRegister = findViewById<TextInputEditText>(R.id.email_register)
            val passwordRegister = findViewById<TextInputEditText>(R.id.password_register)
            val confirmpwdRegister = findViewById<TextInputEditText>(R.id.confirmpwd_register)

            val email = emailRegister.text.toString()
            val password = passwordRegister.text.toString()
            val confirmPassword = confirmpwdRegister.text.toString()

            if (password != confirmPassword) {
                // Jika password dan konfirmasi password tidak cocok, tampilkan pesan toast
                Toast.makeText(
                    this,
                    "Password dan Confirm Password harus sama!",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("username", email)
            editor.putString("password", password)
            editor.apply()

            Toast.makeText(this, "Akun anda telah terdaftar", Toast.LENGTH_SHORT).show()
        }

        val kembalimainButton: Button = findViewById(R.id.back2login)
        kembalimainButton.setOnClickListener {
            val intent = Intent(this@Register, MainActivity::class.java)
            startActivity(intent)
        }
    }

}