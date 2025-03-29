plugins {
    kotlin("jvm") version "2.1.20"
    id("application")
}

group = "com.lotsofpixelsstudios"   //todo
version = "1"

repositories {
    mavenCentral()
}

application {
    val mainClassFind = layout
        .projectDirectory
        .asFileTree
        .firstOrNull { it.name == "Main.kt" }
        ?.path
        ?.split("kotlin")
        ?.last()
        ?.removePrefix(File.separator)
        ?.split(File.separator)
        ?.joinToString(".")
        ?.replace("Main.kt", "MainKt")
    mainClass.set(mainClassFind)
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("com.lotsofpixelsstudios:monstera:0.5.9")
    implementation("com.lotsofpixelsstudios:monstera-stdlib:0.11.4")

    // https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
    implementation("ch.qos.logback:logback-classic:1.5.18")
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-api
    implementation("org.slf4j:slf4j-api:2.0.17")

    //test
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

//monstera tasks
apply(from = File("tasks", "buildAddon.gradle.kts"))
apply(from = File("tasks", "cleanAllAddons.gradle.kts"))
apply(from = File("tasks", "cleanAllWorlds.gradle.kts"))