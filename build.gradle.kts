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
    id("idea")
    id("maven-publish")
}

group = properties["ARTIFACT_PACKAGE"] as String
version = properties["ARTIFACT_VERSION"] as String

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    withJavadocJar()
    withSourcesJar()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(Kotlin.stdlib)
    implementation(KotlinX.coroutines.core)

    kapt(Square.moshi.kotlinCodegen)
    implementation(Square.moshi)
    implementation(JakeWharton.moshi.shimo)

    implementation(Square.retrofit2.retrofit)
    implementation(Square.retrofit2.converter.scalars)
    implementation(Square.retrofit2.converter.moshi)

    implementation(Square.okHttp3.okHttp)
    implementation(Square.okHttp3.loggingInterceptor)
    implementation("se.akerfeldt:okhttp-signpost:_")
    implementation("oauth.signpost:signpost-core:_")

    testImplementation(Testing.junit4)
}

idea {
    module {
        sourceDirs.addAll(files("build/generated/source/kapt/main", "build/generated/source/kaptKotlin/main"))
        generatedSourceDirs.addAll(files("build/generated/source/kapt/main", "build/generated/source/kaptKotlin/main"))
    }
}

kotlin {
    explicitApi()
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

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/stilllynnthecloset/kotlr")
            credentials {
                username = (project.findProperty("gpr.user") ?: System.getenv("GITHUB_USERNAME")).toString()
                password = (project.findProperty("gpr.key") ?: System.getenv("GITHUB_TOKEN")).toString()
            }
        }
    }
    publications {
        create<MavenPublication>("gpr") {
            groupId = properties["ARTIFACT_PACKAGE"] as String
            artifactId = properties["ARTIFACT_NAME"] as String
            version = properties["ARTIFACT_VERSION"] as String

            from(components["java"])
        }
    }
}

tasks.withType<Wrapper> {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "6.8.2"
}
