package com.example.srreferenceapp

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

        val tvWelcomeUser = findViewById<TextView>(R.id.tvWelcomeUser)
        val tvMemberIdDisplay = findViewById<TextView>(R.id.tvMemberIdDisplay)
        val cardFood = findViewById<CardView>(R.id.cardFood)
        val cardGrocery = findViewById<CardView>(R.id.cardGrocery)
        val cardDeals = findViewById<CardView>(R.id.cardDeals)
        val tvViewHistory = findViewById<TextView>(R.id.tvViewHistory)

        val profileView = findViewById<ImageButton>(R.id.profile)
        val btnCartContainer = findViewById<FrameLayout>(R.id.btnCartContainer)

        val firstName = intent.getStringExtra("FIRST_NAME")
        val lastName = intent.getStringExtra("LAST_NAME")
        val email = intent.getStringExtra("EMAIL")
        val memberId = intent.getStringExtra("MEMBER_ID")

        tvWelcomeUser.text = if (!firstName.isNullOrEmpty()) "Welcome back, $firstName!" else "Welcome back, Guest!"
        tvMemberIdDisplay.text = if (!memberId.isNullOrEmpty()) "Member ID: $memberId" else "Member ID: No membership"

        btnCartContainer.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Opening Cart...", Toast.LENGTH_SHORT).show()
        }

        profileView.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra("FIRST_NAME", firstName)
                putExtra("LAST_NAME", lastName)
                putExtra("EMAIL", email)
                putExtra("MEMBER_NUM", memberId)
            }
            startActivity(intent)
        }

        cardFood.setOnClickListener {
            val intent = Intent(this, FoodServiceActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Opening Food Service...", Toast.LENGTH_SHORT).show()
        }

        cardGrocery.setOnClickListener {
            Toast.makeText(this, "Opening Warehouse Grocery...", Toast.LENGTH_SHORT).show()
        }

        cardDeals.setOnClickListener {
            Toast.makeText(this, "Checking Membership Deals...", Toast.LENGTH_SHORT).show()
        }

        tvViewHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Opening Order History...", Toast.LENGTH_SHORT).show()
        }
    }
}