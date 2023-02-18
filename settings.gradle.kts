plugins {
    id("de.fayard.refreshVersions") version "0.51.0"
}

rootProject.name = "kotlr"

include(":lib", ":demo")


refreshVersions {
    rejectVersionIf {
        candidate.stabilityLevel.isLessStableThan(current.stabilityLevel)
    }
}
