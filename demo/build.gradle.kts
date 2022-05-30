import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }
}

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.kapt")
    id("org.jlleitschuh.gradle.ktlint")
}

group = properties["ARTIFACT_PACKAGE"] as String
version = properties["ARTIFACT_VERSION"] as String

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(project(":lib"))

    implementation(Kotlin.stdlib)
    implementation(KotlinX.coroutines.core)

    kapt(Square.moshi.kotlinCodegen)
    implementation(Square.moshi)
}

ktlint {
    version.set("0.42.1")
    debug.set(false)
    verbose.set(true)
    android.set(false)
    outputToConsole.set(true)
    ignoreFailures.set(false)
    enableExperimentalRules.set(true)
    disabledRules.set(
        setOf(
            "experimental:argument-list-wrapping"
        )
    )

    filter {
        include("src/**")
    }
}

tasks.withType<Wrapper> {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "6.8.2"
}
