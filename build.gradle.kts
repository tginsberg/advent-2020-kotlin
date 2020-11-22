/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

plugins {
    kotlin("jvm") version "1.4.10"
}

repositories {
   mavenCentral()
}

dependencies {
    testApi("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    testImplementation("org.assertj:assertj-core:3.18.1")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
    test {
        useJUnitPlatform()
    }
}
