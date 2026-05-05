package com.example.srreferenceapp

data class OrderHistory(
    val orderId: String,
    val date: String,
    val totalAmount: Double,
    val status: String
)