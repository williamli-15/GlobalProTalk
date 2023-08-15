rootProject.name = "cp"

pluginManagement {
    includeBuild("build-logic")
}


include("account-service")
include("post-service")
include("feed-generation-service")