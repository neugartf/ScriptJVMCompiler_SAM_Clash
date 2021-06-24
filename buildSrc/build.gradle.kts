plugins {
    `kotlin-dsl`
}

val kotlinVersion: String by extra("1.5.20")
val kotlinXVersion: String by extra("1.5.0")

dependencies {
    implementation(kotlin("scripting-jvm:$kotlinVersion"))
    implementation(kotlin("scripting-jvm-host:$kotlinVersion"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinXVersion")
}

repositories {
    mavenCentral()
}