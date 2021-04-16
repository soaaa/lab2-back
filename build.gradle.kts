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
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.2")
    implementation("org.apache.httpcomponents:httpclient:4.5.2")
}