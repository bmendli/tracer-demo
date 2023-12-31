plugins {
    id("com.android.application")
    kotlin("android")
    id("ru.ok.tracer") version("0.2.6")
}

android {
    namespace = "ru.ok.tracer.demo"
    compileSdk = 33

    defaultConfig {
        applicationId = "ru.ok.tracer.demo"
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

tracer {
    create("defaultConfig") {
        // См. в разделе "Настройки"
        pluginToken = "ZGUmPPwA1YiLGrAV8YVS6lUxyVEgMm3CK1yOsdjR6kd"
        appToken = "6sDksybrBjPojOgvkhDccky73Z5X2ujBC1bwVO2mYVT"

        // Включает загрузку маппингов для билда. По умолчанию включена
        uploadMapping = true
    }
}

dependencies {
    // Плагины независимы друг от друга. Можно подключать только те,
    // которые необходимы в данный момент.

    // Сбор и анализ крешей и ANR
    implementation("ru.ok.tracer:tracer-crash-report:0.2.6")
    // Сбор и анализ нативных крешей
    implementation("ru.ok.tracer:tracer-crash-report-native:0.2.6")
    // Сбор и анализ хипдапмов при OOM
    implementation("ru.ok.tracer:tracer-heap-dumps:0.2.6")
    // Анализ потребления дискового места на устройстве
    implementation("ru.ok.tracer:tracer-disk-usage:0.2.6")
    // Семплирующий профайлер
    implementation("ru.ok.tracer:tracer-profiler-sampling:0.2.6")
    // Систрейс
    implementation("ru.ok.tracer:tracer-profiler-systrace:0.2.6")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}