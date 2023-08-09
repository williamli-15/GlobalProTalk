plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    id("com.abx.build.java-conventions")
}

dependencies {
    implementation("org.springframework.kafka:spring-kafka:3.0.4")
    implementation("org.springframework.boot:spring-boot-starter-data-cassandra:3.0.4")
    implementation("org.projectlombok:lombok:1.18.26")
}