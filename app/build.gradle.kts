buildscript {
    apply(from="../dependencies/build.gradle")
}
plugins {
    kotlin("jvm")
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    val projectDependency = rootProject.ext["libraries"] as Map<*, *>

    testImplementation(projectDependency["junitJupiter"]!!)
    testRuntimeOnly(projectDependency["junitEngine"]!!)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}