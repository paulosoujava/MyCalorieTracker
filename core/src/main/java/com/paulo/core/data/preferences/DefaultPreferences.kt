package com.paulo.core.data.preferences

import android.content.SharedPreferences
import com.paulo.core.domain.model.ActivityLevel
import com.paulo.core.domain.model.Gender
import com.paulo.core.domain.model.GoalType
import com.paulo.core.domain.model.UserInfo
import com.paulo.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharedPref: SharedPreferences
): Preferences {
    override fun saveGender(gender: Gender) {
        setStringSharedPref(Preferences.KEY_GENDER, gender.name)
    }

    override fun saveAge(age: Int) {
        setIntSharedPref(Preferences.KEY_AGE, age)
    }

    override fun saveWeight(weight: Float) {
        setFloatSharedPref(Preferences.KEY_WEIGHT, weight)
    }

    override fun saveHeight(height: Int) {
        setIntSharedPref(Preferences.KEY_HEIGHT, height)
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        setStringSharedPref(Preferences.KEY_ACTIVITY_LEVEL, level.name)
    }

    override fun saveGoalType(type: GoalType) {
        setStringSharedPref(Preferences.KEY_GOAL_TYPE, type.name)
    }

    override fun saveCarbRatio(ratio: Float) {
        setFloatSharedPref(Preferences.KEY_WEIGHT, ratio)
    }

    override fun saveProteinRatio(ratio: Float) {
        setFloatSharedPref(Preferences.KEY_WEIGHT, ratio)
    }

    override fun saveFatRatio(ratio: Float) {
        setFloatSharedPref(Preferences.KEY_WEIGHT, ratio)
    }

    override fun loadUserInfo(): UserInfo {
        val age = sharedPref.getInt(Preferences.KEY_AGE, -1)
        val height = sharedPref.getInt(Preferences.KEY_HEIGHT, -1)
        val weight = sharedPref.getFloat(Preferences.KEY_WEIGHT, -1f)
        val genderString = sharedPref.getString(Preferences.KEY_GENDER, null)
        val activityLevelString = sharedPref.getString(Preferences.KEY_ACTIVITY_LEVEL, null)
        val goalType = sharedPref.getString(Preferences.KEY_GOAL_TYPE, null)
        val carbRatio = sharedPref.getFloat(Preferences.KEY_CARB_RATIO, -1f)
        val proteinRatio = sharedPref.getFloat(Preferences.KEY_PROTEIN_RATIO, -1f)
        val fatRatio = sharedPref.getFloat(Preferences.KEY_FAT_RATIO, -1f)

        return UserInfo(
            gender = Gender.fromString( genderString ?: "male"),
            age = age,
            weight = weight,
            height = height,
            activityLevel =  ActivityLevel.fromString(activityLevelString ?: "medium"),
            goalType = GoalType.fromString(goalType ?: "keep_weight"),
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio
        )
    }


    override fun saveShouldShowOnboarding(shouldShow: Boolean) {
        setBooleanSharedPref(Preferences.KEY_SHOULD_SHOW_ONBOARDING, shouldShow)
    }

    override fun loadShouldShowOnBoarding(): Boolean {
        return sharedPref.getBoolean(Preferences.KEY_SHOULD_SHOW_ONBOARDING, true)
    }

    private fun setBooleanSharedPref( key: String, value: Boolean ){
        sharedPref.edit()
            .putBoolean(key, value)
            .apply()
    }

    private fun setStringSharedPref( key: String, value: String ){
        sharedPref.edit()
            .putString(key, value)
            .apply()
    }

    private fun setIntSharedPref( key: String, value: Int ){
        sharedPref.edit()
            .putInt(key, value)
            .apply()
    }
    private fun setFloatSharedPref(key: String, value: Float ){
        sharedPref.edit()
            .putFloat(key, value)
            .apply()
    }

}