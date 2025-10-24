plugins {
    id("xyz.wagyourtail.unimined") version "1.4.1"
}


subprojects {
    apply(plugin = "java")
    apply(plugin = "xyz.wagyourtail.unimined")

    unimined.minecraft {
        version("1.7.10")

        mappings {
            calamus()
            feather(28)
        }

        ornitheFabric {
            loader("0.17.3")
        }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

        toolchain {
            languageVersion.set(JavaLanguageVersion.of(8))
        }
    }

    tasks {
        processResources {
            filesMatching("fabric.mod.json") {
                expand(mapOf(
                    "id" to project.properties["mod.id"].toString(),
                    "name" to project.properties["mod.name"].toString(),
                    "version" to project.properties["mod.version"].toString()
                ))
            }
        }
    }
}
