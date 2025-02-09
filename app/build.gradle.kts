plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    id("com.google.gms.google-services")

}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34


    buildFeatures{
        viewBinding = true
    }
    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 26
        targetSdk = 33
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }



}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.13.0-alpha09")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //zegocloud sdk
    implementation ("com.github.ZEGOCLOUD:zego_uikit_prebuilt_call_android:+")

    // Nav component
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

    //cardview
    implementation("androidx.cardview:cardview:1.0.0")

    //circular imageview
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    //Firebase BOM
    implementation(platform("com.google.firebase:firebase-bom:32.7.2"))
    // FB analystics
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-database-ktx")

    // Firebase Auth.
    implementation("com.google.firebase:firebase-auth-ktx")


    // Imageslider
    implementation ("com.github.denzcoskun:ImageSlideshow:0.1.2")

    // Splash Api
    implementation("androidx.core:core-splashscreen:1.0.0")

    // glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    // shimmer
   implementation ("com.facebook.shimmer:shimmer:0.5.0")

    //lotte
    implementation ("com.airbnb.android:lottie:6.1.0")

















}