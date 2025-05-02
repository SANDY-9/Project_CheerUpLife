import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.cheeruplife.core.data"
    compileSdk = 35

    defaultConfig {
        minSdk = 28

        val localProperties = Properties()
        val localPropertiesFile = rootProject.file("local.properties")
        if (localPropertiesFile.exists()) {
            localPropertiesFile.inputStream().use { localProperties.load(it) }
        }
        buildConfigField(
            type = "String",
            name = "WORK24_BASE_URL",
            value = localProperties["work24_base_url"].toString()
        )
        buildConfigField(
            type = "String",
            name = "WORK24_AUTH_KEY_REQRUIT",
            value = localProperties["authKey_reqruit"].toString()
        )
        buildConfigField(
            type = "String",
            name = "WORK24_AUTH_KEY_EVENT",
            value = localProperties["authKey_event"].toString()
        )
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(project(":core:domain"))
    implementation(project(":core:model"))

    implementation(libs.bundles.hilt)
    ksp(libs.hilt.compiler)

    implementation(libs.bundles.retrofit)
    implementation(libs.kotlinx.serialization)

}