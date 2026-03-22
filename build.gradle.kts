plugins {
	kotlin("jvm") version "2.1.10"
	id("io.ktor.plugin") version "3.1.2"
	id("org.jetbrains.kotlin.plugin.serialization") version "2.1.10"
	application
}

group = "com.example"
version = "1.0"

// Java toolchain configuration
java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

kotlin {
	jvmToolchain(21)
}

application {
	mainClass.set("com.example.ApplicationKt")
}

repositories {
	mavenCentral()
}

dependencies {
	// Ktor server
	implementation("io.ktor:ktor-server-core-jvm:3.1.2")
	implementation("io.ktor:ktor-server-netty-jvm:3.1.2")
	implementation("io.ktor:ktor-server-content-negotiation-jvm:3.1.2")
	implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:3.1.2")

	// Logging & metrics
	implementation("io.ktor:ktor-server-call-logging:3.1.2")
	implementation("io.ktor:ktor-server-metrics-micrometer:3.1.2")
	implementation("io.ktor:ktor-metrics-micrometer:1.6.8")
	implementation("io.micrometer:micrometer-registry-prometheus:1.14.0")

	// Dependency injection (Koin)
	implementation("io.insert-koin:koin-ktor:4.0.0")
	implementation("io.insert-koin:koin-logger-slf4j:4.0.0")

	// Database (Exposed + HikariCP)
	implementation("org.jetbrains.exposed:exposed-core:0.60.0")
	implementation("org.jetbrains.exposed:exposed-dao:0.60.0")
	implementation("org.jetbrains.exposed:exposed-jdbc:0.60.0")
	implementation("org.jetbrains.exposed:exposed-java-time:0.60.0")
	implementation("com.zaxxer:HikariCP:6.2.1")
	implementation("org.postgresql:postgresql:42.7.4")

	// Client for inter-service communication
	implementation("io.ktor:ktor-client-core:3.1.2")
	implementation("io.ktor:ktor-client-cio:3.1.2")
	implementation("io.ktor:ktor-client-content-negotiation:3.1.2")

	// Logging
	implementation("ch.qos.logback:logback-classic:1.5.16")

	// Testing
	testImplementation("io.ktor:ktor-server-test-host:3.1.2")
	testImplementation("org.jetbrains.kotlin:kotlin-test:2.1.10")
	testImplementation("io.insert-koin:koin-test:4.0.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}