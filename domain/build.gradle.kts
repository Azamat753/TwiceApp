plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}
repositories {
    google()
    mavenCentral()
}
android {
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSDK
        targetSdk = Config.targetSDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.material)
    implementation(Dependencies.Android.constraint)
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.androidJUnit)
    androidTestImplementation(Dependencies.Test.espresso)
    androidTestImplementation(Dependencies.Test.uiAutomator)

    //Hilt
    implementation(Dependencies.Hilt.android)
    kapt(Dependencies.Hilt.compiler)

    //Coroutines
    implementation(Dependencies.Coroutines.coreCoroutines)

    //KTX
    implementation(Dependencies.Lifecycle.lifecycleKtx)
    implementation(Dependencies.Lifecycle.lifecycleViewModel)
    implementation(Dependencies.Lifecycle.lifecycleFragment)

    implementation(project(":core"))
}