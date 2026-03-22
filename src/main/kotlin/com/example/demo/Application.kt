package com.example.demo

import com.example.demo.plugins.configureMonitoring
import com.example.demo.routes.configureRouting
import configureDI
import configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*


fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    // Install plugins
    configureDI()
    configureMonitoring()
    configureSerialization()
    configureRouting()
}
