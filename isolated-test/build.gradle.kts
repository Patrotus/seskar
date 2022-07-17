plugins {
    kotlin("js") version "1.7.10"
    id("io.github.turansky.kfc.application") version "5.52.0"
    id("io.github.turansky.seskar") version "0.16.0"
}

dependencies {
    implementation("io.github.turansky.seskar:seskar-core:0.16.0")

    testImplementation(kotlin("test-js"))
}

tasks.wrapper {
    gradleVersion = "7.4.2"
}
