package com.example.demo.routes

import com.example.demo.service.ProductService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

    val productService: ProductService by inject()

    routing {
        // Product routes under /api/products
        route("/api/products") {
            productRoutes(productService)
        }

        // Health check
        get("/health") {
            call.respond(
                mapOf(
                    "status" to "UP",
                    "service" to "product-service",
                    "timestamp" to System.currentTimeMillis().toString()
                )
            )
        }
    }
}