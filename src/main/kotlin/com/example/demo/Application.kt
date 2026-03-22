package com.example.demo

import com.example.demo.plugins.configureMonitoring
import com.example.demo.routes.configureRouting
import configureDI
import configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080) {
        module()
    }.start(wait = true)
}

fun Application.module() {
    // Install plugins
    configureDI()
    configureMonitoring()
    configureSerialization()
    configureRouting()
}
