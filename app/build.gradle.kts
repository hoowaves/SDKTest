plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.amuz.kotlin_test_app_2"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.amuz.kotlin_test_app_2"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    useLibrary("org.apache.http.legacy")
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //implementation("com.connectsdk:connect-sdk-android:1.6.0")
//    implementation(":Connect-SDK-Android")
    implementation("androidx.compose.runtime:runtime-livedata:1.0.0")

    implementation("org.java-websocket:Java-WebSocket:1.5.0")
    implementation("javax.jmdns:jmdns:3.4.1")
    implementation(fileTree(mapOf("dir" to "modules/firetv/libs", "include" to "*.jar")))
    implementation("androidx.mediarouter:mediarouter:1.2.0")
    implementation("androidx.annotation:annotation:1.0.0")
    implementation("androidx.preference:preference:1.1.1")
    implementation("androidx.appcompat:appcompat:1.3.1")  // 1.4.1 version doesn't support compile sdk 30
    implementation("com.googlecode.plist:dd-plist:1.23")
    implementation("com.nimbusds:srp6a:2.1.0")
    implementation("net.i2p.crypto:eddsa:0.3.0")
    implementation("com.google.android.gms:play-services-cast-framework:9.4.0")
    implementation(files("libs/lgcast-android-lib.jar"))
    testImplementation("org.apache.maven:maven-ant-tasks:2.1.3")
    testImplementation("junit:junit:4.12")
    testImplementation("org.robolectric:robolectric:2.4")
    testImplementation("org.mockito:mockito-all:1.10.19")
    testImplementation("org.powermock:powermock-api-mockito:1.6.2")
    testImplementation("xmlunit:xmlunit:1.4")

}