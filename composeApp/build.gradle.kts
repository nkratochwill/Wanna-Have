import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.projectDir.path)
                    }
                }
            }
        }
        binaries.executable()
    }
    
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm("desktop") // "desktop" needed for val desktopMain by getting
    
    sourceSets {
        val desktopMain by getting
        
        androidMain.dependencies {
            // IMPLEMENTATION START
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            // IMPLEMENTATION END
        }
        commonMain.dependencies {
            // IMPLEMENTATION PROJECT START
            implementation(projects.core.designsystem)
            implementation(projects.shared)
            // IMPLEMENTATION PROJECT END

            // IMPLEMENTATION START
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.runtime)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.material3.windowSizeClass.multiplatform)
            // IMPLEMENTATION END
        }
        desktopMain.dependencies {
            // IMPLEMENTATION START
            implementation(compose.desktop.currentOs)
            // IMPLEMENTATION END
        }
    }
}

android {
    namespace = "org.wannahave"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "org.wannahave"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    dependencies {
        // DEBUGIMPLEMENTATION START
        debugImplementation(compose.uiTooling)
        // DEBUGIMPLEMENTATION END
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Exe, TargetFormat.Deb)
            packageName = "Wanna Have"
            packageVersion = "1.0.0"
            jvmArgs("-Dapple.awt.application.appearance=system")

            // TODO ICON
            // macOS {
            //     iconFile.set(project.file("icon.icns"))
            // }
            // windows {
            //     iconFile.set(project.file("icon.ico"))
            // }
            // linux {
            //     iconFile.set(project.file("icon.png"))
            // }
        }
    }
}
