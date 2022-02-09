package com.paulo.core.domain.model

sealed class Gender(val name: String) {
    object Male : Gender("male")
    object Female : Gender("female")

    companion object {
        fun fromString(name: String): Gender {
            return  if(name == "male") Male else Female
            /*return when (name) {
                "male" -> Male
                else-> Female
            }*/
        }
    }
}