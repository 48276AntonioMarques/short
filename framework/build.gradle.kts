plugins {
    kotlin("jvm") version "1.9.20"
}

group = "pt.isel.short"
version = "0.5.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    implementation(group = "org.http4k", name = "http4k-core", version = "5.14.+")
    implementation(group = "org.http4k", name = "http4k-server-jetty", version = "5.14.+")
    implementation( group = "com.google.code.gson", name = "gson", version = "2.10.+")

    implementation(group = "io.github.oshai", name = "kotlin-logging-jvm", version = "6.0.+")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}