plugins {
    id("xyz.wagyourtail.unimined") version "1.4.1"
}


subprojects {
    apply(plugin = "java")
    apply(plugin = "xyz.wagyourtail.unimined")

    unimined.useGlobalCache = false

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
}
