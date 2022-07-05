object Dependencies {

    object Hilt {
        private const val version = "2.42"
        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
    }

    object Android {
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val material = "com.google.android.material:material:1.6.1"
        const val appCompat = "androidx.appcompat:appcompat:1.4.1"
        const val coil = "io.coil-kt:coil:2.1.0"
        const val glide = "com.github.bumptech.glide:glide:4.12.0"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.1.4"
    }

    object Lifecycle {
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"
        const val lifecycleFragment = "androidx.fragment:fragment-ktx:1.4.1"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0-rc01"
    }

    object Test {
        const val jUnit = "junit:junit:4.+"
        const val androidJUnit = "androidx.test.ext:junit:1.1.2"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
        const val uiAutomator = "androidx.test.uiautomator:uiautomator:2.2.0"
    }


    object Paging {
        const val paging_v3 = "androidx.paging:paging-runtime-ktx:3.1.1"
    }

    object NavigationComponent {
        private const val nav_version = "2.4.2"
        const val nav_fragment = "androidx.navigation:navigation-fragment-ktx:$nav_version"
        const val nav_ui = "androidx.navigation:navigation-ui-ktx:$nav_version"
    }

    object Coroutines {
        const val coreCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1"
    }

    object ViewBinding {
        const val binding = "androidx.databinding:viewbinding:7.2.1"
    }

    object FireBase {

    }

}