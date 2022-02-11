apply {
    from("$rootDir/base-module.gradle")
}
// if you have dependencies to this module
dependencies {
    "implementation"(project(Modules.core))
    "implementation"(Coroutines.coroutines)
}