import kotlin.String
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

/**
 * Generated by https://github.com/jmfayard/buildSrcVersions
 *
 * Find which updates are available by running
 *     `$ ./gradlew buildSrcVersions`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version.
 */
object Versions {
    const val org_jetbrains_kotlinx_kotlinx_coroutines: String = "1.3.9"

    const val com_squareup_retrofit2: String = "2.9.0"

    const val com_squareup_okhttp3: String = "4.8.1"

    const val org_jetbrains_kotlin: String = "1.4.0"

    const val com_squareup_moshi: String = "1.9.3"

    const val com_github_ben_manes_versions_gradle_plugin: String = "0.29.0"

    const val org_jlleitschuh_gradle_ktlint_gradle_plugin: String = "9.3.0"

    const val de_fayard_buildsrcversions_gradle_plugin: String = "0.7.0"

    const val org_jetbrains_kotlin_kapt_gradle_plugin: String = "1.4.0"

    const val org_jetbrains_kotlin_jvm_gradle_plugin: String = "1.4.0"

    const val okhttp_signpost: String = "1.1.0"

    const val signpost_core: String = "2.1.1"

    const val wagon_git: String = "0.3.0"

    const val ktlint: String = "0.38.1"

    const val junit: String = "4.13"

    /**
     * Current version: "6.6.1"
     * See issue 19: How to update Gradle itself?
     * https://github.com/jmfayard/buildSrcVersions/issues/19
     */
    const val gradleLatestVersion: String = "6.6.1"
}

/**
 * See issue #47: how to update buildSrcVersions itself
 * https://github.com/jmfayard/buildSrcVersions/issues/47
 */
val PluginDependenciesSpec.buildSrcVersions: PluginDependencySpec
    inline get() =
            id("de.fayard.buildSrcVersions").version(Versions.de_fayard_buildsrcversions_gradle_plugin)
