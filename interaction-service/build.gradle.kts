plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    id("com.abx.build.java-conventions")

//    id("org.flywaydb.flyway") version "9.8.1"
}

//flyway {
//    url = "jdbc:postgresql://localhost:5432/from0to1_PSQL"
//    user = "postgres"
//    password = "postgres"
//}