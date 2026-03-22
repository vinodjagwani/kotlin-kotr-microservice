package com.example.demo.routes

import com.example.demo.service.NotFoundException
import com.example.demo.service.ProductService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.productRoutes(productService: ProductService) {

    // GET /api/products - Get all products
    get("") {
        val products = productService.getAllProducts()
        call.respond(products)
    }

    // GET /api/products/{id} - Get product by ID
    get("/{id}") {
        val id = call.parameters["id"]?.toLongOrNull()
            ?: return@get call.respond(
                HttpStatusCode.BadRequest,
                mapOf("error" to "Invalid ID format")
            )

        productService.getProduct(id).fold(
            onSuccess = { product ->
                call.respond(product)
            },
            onFailure = { error ->
                call.handleError(error)
            }
        )
    }
}

private suspend fun ApplicationCall.handleError(error: Throwable) {
    val status = when (error) {
        is NotFoundException -> HttpStatusCode.NotFound
        else -> HttpStatusCode.InternalServerError
    }
    respond(
        status,
        mapOf("error" to (error.message ?: "Unknown error"))
    )
}