/*
 * This file was generated by the Gradle 'init' task.
 *
*/

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    kotlin("jvm") version "1.8.10"

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use the Kotlin JUnit 5 integration.
    testImplementation(kotlin("test"))

    implementation("info.picocli:picocli:4.7.1")
}

application {
    // Define the main class for the application.
    mainClass.set("softdevSpringTask.TarKt")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes["Tar-Class"] = "TarKt"
        attributes["Main-Class"] = "softdevSpringTask.TarKt"
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}