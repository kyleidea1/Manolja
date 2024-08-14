// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.ksp) // KSP 플러그인 추가
    id("com.google.gms.google-services") version "4.4.2" apply false // Google Services 플러그인 버전 설정
}