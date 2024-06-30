plugins {
    kotlin("jvm") version "1.9.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(project(":framework"))
    implementation(group = "org.apache.logging.log4j", name = "log4j-slf4j2-impl", version = "2.23.+")
    implementation(group = "org.mindrot", name = "jbcrypt", version = "0.4")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
