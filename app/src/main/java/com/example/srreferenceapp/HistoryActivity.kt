package com.example.srreferenceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton // Added Import
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)

            finish()
        }

        val historyListView: ListView = findViewById(R.id.historyListView)


        val orders = listOf(
            OrderHistory("ORD-001", "2026-04-10", 25.50, "Delivered"),
            OrderHistory("ORD-002", "2026-04-15", 12.99, "Delivered"),
            OrderHistory("ORD-003", "2026-04-20", 45.00, "In Progress")
        )


        val adapter = object : ArrayAdapter<OrderHistory>(this, R.layout.item_order, orders) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = convertView ?: layoutInflater.inflate(R.layout.item_order, parent, false)

                val currentOrder = getItem(position)

                val idText = view.findViewById<TextView>(R.id.tvOrderId)
                val dateText = view.findViewById<TextView>(R.id.tvOrderDate)
                val totalText = view.findViewById<TextView>(R.id.tvOrderTotal)

                currentOrder?.let {
                    idText.text = "Order ID: ${it.orderId}"
                    dateText.text = "Date: ${it.date} | ${it.status}"
                    totalText.text = "Total: ₱${String.format(Locale.US, "%.2f", it.totalAmount)}"
                }

                return view
            }
        }

        historyListView.adapter = adapter
    }
}