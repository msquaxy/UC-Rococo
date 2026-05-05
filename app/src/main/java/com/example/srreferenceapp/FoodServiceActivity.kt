package com.example.srreferenceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FoodServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.foodservices)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val btnFoodCart = findViewById<FrameLayout>(R.id.btnFoodCart)
        val btnAddPizza = findViewById<Button>(R.id.btnAddPizza)
        val btnAddChicken = findViewById<Button>(R.id.btnAddChicken)

        btnBack.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        btnAddPizza.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            intent.putExtra("ITEM_NAME", "Pepperoni Pizza")
            intent.putExtra("ITEM_PRICE", "₱499.00")

            startActivity(intent)
            Toast.makeText(this, "Pizza added to cart!", Toast.LENGTH_SHORT).show()
        }

        btnAddChicken.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            intent.putExtra("ITEM_NAME", "Fried Chicken Bucket")
            intent.putExtra("ITEM_PRICE", "₱350.00")

            startActivity(intent)
            Toast.makeText(this, "Chicken added to cart!", Toast.LENGTH_SHORT).show()
        }
    }
}