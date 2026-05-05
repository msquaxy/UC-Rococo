package com.example.srreferenceapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart)

        val btnClose = findViewById<ImageButton>(R.id.btnClose)
        val itemSpinner = findViewById<Spinner>(R.id.itemSpinner)
        val tvPriceValue = findViewById<TextView>(R.id.tvPriceValue)

        val itemName = intent.getStringExtra("ITEM_NAME") ?: "No Item Selected"
        val itemPrice = intent.getStringExtra("ITEM_PRICE") ?: "₱ 0.00"

        val itemList = arrayListOf(itemName)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        itemSpinner.adapter = adapter

        tvPriceValue.text = itemPrice

        btnClose.setOnClickListener {

            finish()
        }
    }
}