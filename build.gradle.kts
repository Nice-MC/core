plugins {
    kotlin("jvm") version "1.8.0"
}

group = "br.com.nicemc.principal.core"
version = "1.0.0"

val spigotVersion = "1.8.8-R0.1-SNAPSHOT"
val niceApiVersion = "1.0.0"

val hikaricpVersion = "5.0.1" // optional dependency
val exposedVersion = "0.41.1" // optional dependency

repositories {
    jcenter()
    mavenLocal()

    // Spigot
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
}

dependencies {
    compileOnly(kotlin("stdlib-jdk8")) // embedded in KotlinBukkitAPI

    compileOnly("org.spigotmc:spigot-api:$spigotVersion")
    implementation("com.github.okkero:skedule:1.2.6")

    // -- NiceAPI
    compileOnly("br.com.nicemc.api:core:$niceApiVersion")
    compileOnly("br.com.nicemc.api:serialization:$niceApiVersion")
    compileOnly("br.com.nicemc.api:exposed:$niceApiVersion")

    // -- Database
    implementation("com.zaxxer:HikariCP:$hikaricpVersion")
    implementation("org.postgresql:postgresql:42.5.4")

    // -- Exposed
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}
