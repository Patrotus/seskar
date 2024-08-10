plugins {
    id("io.github.turansky.kfc.application")
    id("io.github.turansky.kfc.wrappers")
    id("io.github.turansky.seskar")
}

val coroutinesVersion = project.property("kotlinx-coroutines.version") as String

dependencies {
    jsMainImplementation(project(":tests:data"))
    jsMainImplementation(wrappers("react-dom"))
    jsMainImplementation(wrappers("react-use"))

    jsTestImplementation(kotlin("test-js"))
    jsTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:$coroutinesVersion")
    jsTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")
    jsTestImplementation(project(":tests:react-test"))
    jsTestImplementation(wrappers("react-dom-test-utils"))
}
