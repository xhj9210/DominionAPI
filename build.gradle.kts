plugins {
    id("java")
    id("maven-publish")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    withJavadocJar()
    withSourcesJar()
}

group = "cn.lunadeer"
version = "3.2-SNAPSHOT"

// utf-8
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://oss.sonatype.org/content/groups/public")
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    compileOnly("cn.lunadeer:MinecraftPluginUtils:2.0.7")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = project.name
            groupId = project.group.toString()
            version = project.version.toString()
            // Add only the necessary artifacts manually to avoid conflicts
            artifact(tasks.jar.get())  // The main JAR file without classifier
            artifact(tasks.named<Jar>("sourcesJar").get()) {
                classifier = "sources"
            }
            artifact(tasks.named<Jar>("javadocJar").get()) {
                classifier = "javadoc"
            }
        }
    }
    repositories {
        maven {
            url = uri("https://ssl.lunadeer.cn:14454/repository/maven-snapshots/")
            credentials {
                // from m2 settings.xml
                username = project.findProperty("nexusUsername")?.toString()
                password = project.findProperty("nexusPassword")?.toString()
            }
        }
    }
}
