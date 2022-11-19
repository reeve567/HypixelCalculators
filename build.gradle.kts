val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
	application
	kotlin("jvm") version "1.7.21"
	id("io.ktor.plugin") version "2.1.3"
}

group = "dev.reeve"
version = "0.0.1"
application {
	mainClass.set("dev.reeve.ApplicationKt")

	val isDevelopment: Boolean = project.ext.has("development")
	applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
	mavenCentral()
	maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers") }
}

dependencies {
	implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
	implementation("io.ktor:ktor-server-sessions-jvm:$ktor_version")
	implementation("io.ktor:ktor-server-html-builder-jvm:$ktor_version")
	implementation("org.jetbrains:kotlin-css-jvm:1.0.0-pre.129-kotlin-1.4.20")
	implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
	implementation("io.ktor:ktor-serialization-gson-jvm:$ktor_version")
	implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
	implementation("ch.qos.logback:logback-classic:$logback_version")
	implementation("com.squareup.okhttp3:okhttp:4.10.0")
	implementation("com.influxdb:influxdb-client-kotlin:6.7.0")

	testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}