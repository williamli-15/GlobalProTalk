plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    id("com.abx.build.java-conventions")

//    id("org.flywaydb.flyway") version "9.8.1"
}

dependencies{
//    implementation("org.projectlombok:lombok:1.18.24") // Lombok dependency
//    annotationProcessor("org.projectlombok:lombok:1.18.24") // Lombok annotation processor
    implementation("org.immutables:value:2.9.3") // Immutables dependency
    annotationProcessor("org.immutables:value:2.9.3") // Immutables annotation processor

    implementation("org.springframework.boot:spring-boot-starter-web") // For Spring Web
    implementation("org.springframework.boot:spring-boot-starter-data-jpa") // For Spring Data JPA

    implementation("org.postgresql:postgresql") // Add PostgreSQL driver for JPA

    implementation("software.amazon.awssdk:dynamodb:2.20.120")

}

//flyway {
//    url = "jdbc:postgresql://localhost:5432/from0to1_PSQL"
//    user = "postgres"
//    password = "postgres"
//}