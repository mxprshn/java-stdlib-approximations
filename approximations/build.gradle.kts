plugins {
    java
    `maven-publish`
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.jacodb:jacodb-approximations:1.2.0")
    compileOnly(files(rootDir.resolve("usvm-api/usvm-api.jar")))
}

group = "org.usvm.approximations.java.stdlib"
version = "0.0.0"

tasks.withType<JavaCompile> {
    options.release = 8
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
