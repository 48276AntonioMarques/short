pluginManagement {
    plugins {
        id("org.jetbrains.kotlin.jvm") version "1.8.10"
    }
}

rootProject.name = "short"
include("app")
include("framework")
include("htmlGenerator")
