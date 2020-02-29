import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }
}

plugins {
    kotlin("jvm") version "1.3.61"
    kotlin("kapt") version "1.3.61"
    id("com.github.ben-manes.versions") version "0.28.0"
    id("de.fayard.buildSrcVersions") version "0.7.0"
    // id("de.fayard.refreshVersions") version "0.7.0" // Soon this will be the future!
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
    id("idea")
}

apply(from = "publish-bitbucket.gradle")

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
    maven(url = "https://raw.github.com/synergian/wagon-git/releases")
}

dependencies {
    implementation(Libs.kotlin_stdlib)
    implementation(Libs.kotlinx_coroutines_core)

    kapt(Libs.moshi_kotlin_codegen)
    implementation(Libs.moshi)
    implementation(Libs.moshi_adapters)

    implementation(Libs.retrofit)
    implementation(Libs.converter_scalars)
    implementation(Libs.converter_moshi)

    implementation(Libs.okhttp)
    implementation(Libs.logging_interceptor)
    implementation(Libs.okhttp_signpost)
    implementation(Libs.signpost_core)

    testImplementation(Libs.junit)
}

idea {
    module {
        sourceDirs.addAll(files("build/generated/source/kapt/main", "build/generated/source/kaptKotlin/main"))
        generatedSourceDirs.addAll(files("build/generated/source/kapt/main", "build/generated/source/kaptKotlin/main"))
    }
}

ktlint {
    version.set("0.34.2")
    debug.set(false)
    verbose.set(true)
    android.set(false)
    outputToConsole.set(true)
    ignoreFailures.set(true)

    kotlinScriptAdditionalPaths {
        include(fileTree("scripts/"))
    }
    filter {
        exclude("**/generated/**")
        include("**/kotlin/**")
    }
}

tasks.withType<Wrapper> {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = Versions.gradleLatestVersion
}
