pluginManagement {
    repositories {
        mavenCentral()
        maven("https://maven.minecraftforge.net/")
        maven("https://maven.wagyourtail.xyz/releases")
        gradlePluginPortal()
    }
}

rootProject.name = "VintageMods"

include(
    "AlwaysSprint",
    "BasicCPS",
    "BasicFPS",
    "PotionStatus"
)