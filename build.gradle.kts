plugins {
    // Common Java plugins
    id("java")
    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

    // Common Kotlin plugins
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

group = "com.example.uad"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // ORG-Spring libs
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // Kotling libs
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // DB libs
    implementation("org.flywaydb:flyway-core:8.0.5")
    implementation("org.postgresql:postgresql:42.5.1")
    implementation("org.testcontainers:postgresql:1.17.6")

    // AWS libs
    implementation("software.amazon.awssdk:s3:2.19.12"){
        exclude("software.amazon.awssdk", "netty-nio-client")
        exclude("software.amazon.awssdk", "apache-client")
    }
    implementation("software.amazon.awssdk:url-connection-client:2.19.12")
    implementation("software.amazon.awssdk:apache-client:2.19.12"){
        exclude("commons-logging","commons-logging")
    }
    implementation("com.amazonaws:aws-java-sdk-s3:1.12.380")

    // Common libs
    implementation("org.projectlombok:lombok:1.18.24")
    implementation("commons-codec:commons-codec:1.15")

    // SLF4J
//    implementation("org.slf4j:slf4j-api:1.7.28")
//    implementation("org.slf4j:slf4j-simple:1.7.28")
//    implementation("org.slf4j:jcl-over-slf4j:1.7.28")

    // Test libs
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")

    runtimeOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}