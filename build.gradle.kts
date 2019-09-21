import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

buildscript {
    extra.apply {
        set("kotlin_version", "1.3.41")
        set("moshi_version", "1.8.0")
        set("scribe_version", "6.6.3")
    }

    repositories {
        mavenCentral()
        jcenter()
    }
}

plugins {
    kotlin("jvm") version "1.3.41"
    kotlin("kapt") version "1.3.41"
    id("com.github.ben-manes.versions") version "0.20.0"
    id("org.jlleitschuh.gradle.ktlint") version "8.1.0"
    id("idea")
}

group = "com.highthunder"
version = "0.3.0"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${project.rootProject.ext["kotlin_version"]}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.0")

    kapt("com.squareup.moshi:moshi-kotlin-codegen:${project.rootProject.ext["moshi_version"]}")
    implementation("com.squareup.moshi:moshi:${project.rootProject.ext["moshi_version"]}")
    implementation("com.squareup.moshi:moshi-adapters:${project.rootProject.ext["moshi_version"]}")

    implementation("com.github.scribejava:scribejava-core:${project.rootProject.ext["scribe_version"]}")
    implementation("com.github.scribejava:scribejava-apis:${project.rootProject.ext["scribe_version"]}")
    implementation("com.github.scribejava:scribejava-httpclient-okhttp:${project.rootProject.ext["scribe_version"]}")

    testImplementation("junit:junit:4.12")
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
    reporters.set(mutableSetOf(ReporterType.PLAIN, ReporterType.CHECKSTYLE))

    kotlinScriptAdditionalPaths {
        include(fileTree("scripts/"))
    }
    filter {
        exclude("**/generated/**")
        include("**/kotlin/**")
    }
}
