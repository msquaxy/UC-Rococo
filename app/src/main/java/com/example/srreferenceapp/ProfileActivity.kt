package com.example.srreferenceapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        val btnBack = findViewById<ImageButton>(R.id.btnBackToFood)
        val tvEditProfile = findViewById<TextView>(R.id.tvEditProfileName)

        val firstName = intent.getStringExtra("FIRST_NAME")
        val lastName = intent.getStringExtra("LAST_NAME")
        val memberId = intent.getStringExtra("MEMBER_NUM")
        val phone = intent.getStringExtra("PHONE") ?: ""

        btnBack.setOnClickListener { finish() }

        tvEditProfile.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java).apply {
                putExtra("FIRST_NAME", firstName)
                putExtra("LAST_NAME", lastName)
                putExtra("MEMBER_NUM", memberId)
                putExtra("PHONE", phone)
            }
            startActivity(intent)
        }
    }
}