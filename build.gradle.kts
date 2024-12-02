plugins {
    kotlin("jvm") version "2.0.20"
    application
}

group = "net.codetreats.aoc"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("net.codetreats.aoc.MainKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-common:2.0.20")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.3")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}