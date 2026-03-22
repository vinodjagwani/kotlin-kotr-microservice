plugins {
	alias(libs.plugins.kotlin.jvm)
	alias(libs.plugins.kotlin.serialization)
	alias(libs.plugins.ktor)
	application
}

group = "com.example"
version = "1.0"

repositories {
	mavenCentral()
}

application {
	mainClass = "io.ktor.server.netty.EngineMain"
}

kotlin {
	jvmToolchain(21)
}

dependencies {
	implementation(libs.kotlin.asyncapi.ktor)

	implementation(libs.ktor.server.core)
	implementation(libs.ktor.server.netty)
	implementation(libs.ktor.server.call.logging)
	implementation(libs.ktor.server.content.negotiation)
	implementation(libs.ktor.serialization.kotlinx.json)
	implementation(libs.ktor.server.config.yaml)

	implementation(libs.logback.classic)

	implementation(libs.koin.ktor)
	implementation(libs.koin.logger.slf4j)

	testImplementation(libs.ktor.server.test.host)
	testImplementation(libs.kotlin.test.junit)
}