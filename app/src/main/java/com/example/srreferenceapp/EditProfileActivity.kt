package com.example.srreferenceapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile)

        val etFirstName = findViewById<EditText>(R.id.etEditFirstName)
        val etLastName = findViewById<EditText>(R.id.etEditLastName)
        val etMemberNum = findViewById<EditText>(R.id.etEditMemberNumber)
        val etPhone = findViewById<EditText>(R.id.etEditPhone)
        val etPassword = findViewById<EditText>(R.id.etEditPassword)
        val btnSave = findViewById<Button>(R.id.btnSaveChanges)
        val btnCancel = findViewById<Button>(R.id.btnCancelEdit)

        etFirstName.setText(intent.getStringExtra("FIRST_NAME"))
        etLastName.setText(intent.getStringExtra("LAST_NAME"))
        etMemberNum.setText(intent.getStringExtra("MEMBER_NUM"))
        etPhone.setText(intent.getStringExtra("PHONE"))

        btnSave.setOnClickListener {
            val password = etPassword.text.toString()
            if (password.length >= 6) {
                Toast.makeText(this, "Profile Updated!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                etPassword.error = "Password must be at least 6 characters"
            }
        }

        btnCancel.setOnClickListener { finish() }
    }
}