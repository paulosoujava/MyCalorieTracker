apply {
    from("$rootDir/compose-module.gradle")
}
// if you have dependencies to this module
dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.coreUi))
    "implementation"(project(Modules.onboardingDomain))
}