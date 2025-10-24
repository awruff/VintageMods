plugins {
    id("java")
    id("xyz.wagyourtail.unimined") version ("1.4.1")
}

group = "com.github.awruff"
version = "1.0.0"

unimined.useGlobalCache = false

unimined.minecraft {
    version("1.7.10")

    mappings {
        searge()
        mcp("stable", "12-1.7.10")
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