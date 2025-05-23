pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CheerUpLife"
include(":app")
include(":core:designsystem")
include(":core:model")
include(":core:domain")
include(":core:data")
include(":core:resources")
include(":feature:home")
include(":feature:search")
include(":feature:recruit")
include(":core:network")
include(":feature:schedule")
include(":core:calendar")
