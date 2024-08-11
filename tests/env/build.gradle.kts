plugins {
    alias(libs.plugins.kfc.application)
    id("io.github.turansky.seskar")
}

dependencies {
    jsTestImplementation(libs.kotlin.test.js)
}

tasks.patchBundlerConfig {
    env("BUILD_NUMBER", "generic-number")
    env("NUMBER", "42")
}
