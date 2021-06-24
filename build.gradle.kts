plugins {
    kotlin("jvm") version "1.5.20"
}


group = "org.example"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks {
    val compileScript by registering(CompileScript::class)
}

