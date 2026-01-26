// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("org.sonarqube") version "4.4.1.3373"
}

sonarqube {
    properties {
        property("sonar.projectKey", "android-app")
        property("sonar.projectName", "NavigationController")
        property("sonar.host.url", "http://localhost:9000")
        property("sonar.token", "sqp_7cf1e042da8492d59d391f04ddaa72c0f7f4ba26")
    }
}