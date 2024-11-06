plugins {
    kotlin("jvm") version "1.9.23"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.twilio.sdk:twilio:8.31.1")
    implementation("com.sun.mail:javax.mail:1.6.2")
    implementation("org.mockito:mockito-core:5.5.0")
    implementation("org.mockito:mockito-junit-jupiter:4.11.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}