package com.example.daftarta

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class Reset_pass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pass)

        // Ambil email yang dikirim dari activity sebelumnya
        val email = intent.getStringExtra("email")

        val newPasswordInputText = findViewById<TextInputEditText>(R.id.password_reset)
        val confirmPasswordInputText = findViewById<TextInputEditText>(R.id.confirmpwd_reset)

        val resetButton = findViewById<Button>(R.id.reset)
        resetButton.setOnClickListener {
            val newPassword = newPasswordInputText.text.toString()
            val confirmPassword = confirmPasswordInputText.text.toString()

            if (newPassword != confirmPassword) {
                Toast.makeText(this, "Password dan Confirm Password harus sama!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Simpan password baru ke SharedPreferences
            val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString(email, newPassword) // Simpan password baru dengan menggunakan email sebagai kunci
            editor.apply()

            Toast.makeText(this, "Password berhasil diubah", Toast.LENGTH_SHORT).show()
            finish() // Selesaikan activity reset password
        }

        val kembalimainButton: Button = findViewById(R.id.back2login)
        kembalimainButton.setOnClickListener {
            val intent = Intent(this@Reset_pass, MainActivity::class.java)
            startActivity(intent)
        }
    }
}