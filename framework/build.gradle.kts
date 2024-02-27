plugins {
    kotlin("jvm") version "1.9.20"
    id("org.jlleitschuh.gradle.ktlint") version "11.3.1"
}

group = "pt.isel.short"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib"))

    implementation(group = "org.http4k", name = "http4k-core", version = "5.13.+")
    implementation(group = "org.http4k", name = "http4k-server-jetty", version = "5.13.+")
}

afterEvaluate {
    tasks["ktlintMainSourceSetCheck"].dependsOn(tasks["ktlintMainSourceSetFormat"])
    tasks["ktlintTestSourceSetCheck"].dependsOn(tasks["ktlintTestSourceSetFormat"])
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}