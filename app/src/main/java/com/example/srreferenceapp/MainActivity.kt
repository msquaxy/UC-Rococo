package com.example.srreferenceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val emailField = findViewById<EditText>(R.id.etEmail)
        val passwordField = findViewById<EditText>(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val signUpButton = findViewById<Button>(R.id.btnSignUp)

        loginButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)

                finish()
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }

        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            intent.putExtra("USER_EMAIL", emailField.text.toString())
            startActivity(intent)
        }
    }
}