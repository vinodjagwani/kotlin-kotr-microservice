package com.example.demo.domain

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Long,
    val name: String,
    val price: Double,
    val stock: Int
)