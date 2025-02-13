plugins {
    application
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
}

group = "org.wannahave"
version = "1.0.0"
application {
    mainClass.set("org.wannahave.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

dependencies {
    // IMPLEMENTATION PROJECT START
    implementation(projects.shared)
    // IMPLEMENTATION PROJECT END

    // IMPLEMENTATION START
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    // https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client
    implementation("org.mariadb.jdbc:mariadb-java-client:3.5.2")

    // IMPLEMENTATION END

    // TESTIMPLEMENTATION START
    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.ktor.server.tests)
    // TESTIMPLEMENTATION END
}