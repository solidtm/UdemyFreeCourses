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

rootProject.name = "UdemyFreeCourses"
include(":app")
include(":core")
include(":features")
include(":features:onboarding")
include(":features:home")
include(":features:wishlist")
include(":features:profile")
include(":core:data")
include(":core:ui")
include(":features:auth")
