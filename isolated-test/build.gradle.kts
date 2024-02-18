plugins {
    kotlin("multiplatform") apply false
    id("io.github.turansky.kfc.application")
    id("io.github.turansky.seskar") version "2.40.0"
}

dependencies {
    jsMainImplementation("io.github.turansky.seskar:seskar-core:2.40.0")

    jsTestImplementation(kotlin("test-js"))
}

tasks.wrapper {
    gradleVersion = "8.5"
}
