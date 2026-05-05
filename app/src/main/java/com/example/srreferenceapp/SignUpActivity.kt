package com.example.srreferenceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etMemberNumber = findViewById<EditText>(R.id.etMemberNumber)
        val signUpButton = findViewById<Button>(R.id.btnSignUp)
        val loginButton = findViewById<Button>(R.id.btnLogin)

        loginButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        signUpButton.setOnClickListener {
            val firstName = etFirstName.text.toString().trim()
            val lastName = etLastName.text.toString().trim()
            val memberID = etMemberNumber.text.toString().trim()

            // Validation: Ensure all necessary fields are filled
            if (firstName.isNotEmpty() && lastName.isNotEmpty() && memberID.isNotEmpty()) {
                val intent = Intent(this, MenuActivity::class.java)

                intent.putExtra("FIRST_NAME", firstName)
                intent.putExtra("LAST_NAME", lastName)
                intent.putExtra("MEMBER_ID", memberID)

                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}