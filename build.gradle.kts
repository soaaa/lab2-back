plugins {
    java
    war
}

group = "soa"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-webmvc:5.3.5")
}