package com.example.daftarta
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val selengkapnyaButton: Button = findViewById(R.id.selengkapnya)
        selengkapnyaButton.setOnClickListener {
            val intent = Intent(this@MainActivity, About::class.java)
            startActivity(intent)
        }

        val signUpButton: Button = findViewById(R.id.SignUp)
        signUpButton.setOnClickListener {
            val intent = Intent(this@MainActivity, Register::class.java)
            startActivity(intent)
        }

        val forgotPasswordButton: Button = findViewById(R.id.ForgotPassword)
        forgotPasswordButton.setOnClickListener {
            val intent = Intent(this@MainActivity, Forgot_pass::class.java)
            startActivity(intent)
        }

        val loginButton: Button = findViewById(R.id.login)
        loginButton.setOnClickListener {
            val emailInputText = findViewById<TextInputEditText>(R.id.email)
            val passwordInputText = findViewById<TextInputEditText>(R.id.password)

            val email = emailInputText.text.toString()
            val password = passwordInputText.text.toString()

            val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val savedUsername = sharedPref.getString("username", "")
            val savedPassword = sharedPref.getString("password", "")

            val isPasswordReset = sharedPref.getBoolean("isPasswordReset", false)

            if (isPasswordReset) {
                // Jika password telah di-reset, gunakan password yang baru di-reset
                // untuk melakukan login
                if (email == savedUsername && password == savedPassword) {
                    // Login berhasil
                    Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                    // Redirect ke halaman berikutnya
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                    finish() // Selesaikan activity saat ini agar tidak bisa kembali ke halaman login
                } else {
                    // Login gagal
                    Toast.makeText(
                        this,
                        "Login gagal. Periksa kembali email dan password Anda.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                // Jika password belum di-reset, gunakan password yang telah terdaftar sebelumnya
                // untuk melakukan login
                if (email == savedUsername && password == savedPassword) {
                    // Login berhasil
                    Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                    // Redirect ke halaman berikutnya
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                    finish() // Selesaikan activity saat ini agar tidak bisa kembali ke halaman login
                } else {
                    // Login gagal
                    Toast.makeText(
                        this,
                        "Login gagal. Periksa kembali email dan password Anda.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
