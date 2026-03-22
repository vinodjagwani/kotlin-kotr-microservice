package com.example.demo.service

import com.example.demo.domain.Product


class ProductService {
    private val products = listOf(
        Product(1, "Laptop", 999.99, 10),
        Product(2, "Mouse", 29.99, 50),
        Product(3, "Keyboard", 79.99, 30),
        Product(4, "Monitor", 299.99, 15),
        Product(5, "Headphones", 149.99, 25)
    )

    fun getAllProducts(): List<Product> = products

    fun getProduct(id: Long): Result<Product> {
        val product = products.find { it.id == id }
        return if (product != null) {
            Result.success(product)
        } else {
            Result.failure(NotFoundException("Product $id not found"))
        }
    }
}

class NotFoundException(message: String) : Exception(message)