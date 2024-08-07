plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.mercadolibreapp" // Agrega esta línea
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mercadolibreapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Dependencias de prueba
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.1")
    testImplementation("org.mockito:mockito-core:3.11.2")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.test:core:1.3.0'")
    androidTestImplementation ("androidx.test:rules:1.3.0")
    androidTestImplementation ("androidx.test:runner:1.3.0")
    androidTestImplementation ("com.google.truth:truth:1.1.3")
    androidTestImplementation ("androidx.test.ext:truth:1.4.0")
}
