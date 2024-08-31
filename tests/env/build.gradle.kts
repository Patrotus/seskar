plugins {
    alias(libs.plugins.kfc.library)
    alias(libs.plugins.seskar)
}

bundlerEnvironment {
    set("BUILD_NUMBER", "generic-number")
    set("NUMBER", "42")
}

dependencies {
    jsTestImplementation(libs.kotlin.test.js)
}
