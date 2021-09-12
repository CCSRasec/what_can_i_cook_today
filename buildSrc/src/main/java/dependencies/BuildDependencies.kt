package dependencies

internal object Versions {
    const val jetPackCompose_version = "2.4.0-alpha06"
    const val nav_version = "2.3.5"
}

object Dependencies {

    // Jetpack Compose Integration
    val jetpackCompose = "androidx.navigation:navigation-compose:${Versions.jetPackCompose_version}"

    // Navigation component
    val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"

    // Feature module Support
    val navigationDynamicFeatures =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.nav_version}"

    // Testing Navigation
    val testingNavigationFragment = "androidx.navigation:navigation-testing:${Versions.nav_version}"

}