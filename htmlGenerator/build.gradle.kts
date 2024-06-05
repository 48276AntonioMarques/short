plugins {
    kotlin("jvm") version "1.9.20"
}

group = "pt.isel.SHORT"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation( group = "org.http4k", name = "http4k-client-apache", version = "5.14.+")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}