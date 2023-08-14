plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    id("com.abx.build.java-conventions")
}

dependencies {
    implementation("org.modelmapper:modelmapper:3.1.1")
    annotationProcessor("org.immutables:value:2.9.3")
    compileOnly("org.immutables:value:2.9.3")
}