package com.thezayin.core.preference

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

open class PreferenceManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val PREFS_NAME = "SharedPreferencePhotoStudio"
    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    val isAppFirstTime: Boolean
        get() = (preferences[APP_FIRST_TIME, true] ?: true)

    fun setIsAppFirstTime(isFirstTime: Boolean) {
        preferences[APP_FIRST_TIME] = isFirstTime
    }

    fun clearPrefs() {
        preferences.edit().clear().apply()
    }

    fun setFirstTimeAppOpen(isShown: Boolean) {
        preferences[FIRST_TIME_APP_OPEN] = isShown
    }

    val isFirstTimeAppOpen: Boolean
        get() = (preferences[FIRST_TIME_APP_OPEN] ?: false)

    companion object {
        const val APP_FIRST_TIME = "app_first_time"
        const val FIRST_TIME_APP_OPEN = "first_time_app_open"
    }
}

/**
 * SharedPreferences extension function, to listen the edit() and apply() fun calls
 * on every SharedPreferences operation.
 */
inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
    val editor = this.edit()
    operation(editor)
    editor.apply()
}

/**
 * puts a key value pair in shared prefs if doesn't exists, otherwise updates value on given [key]
 */
operator fun SharedPreferences.set(key: String, value: Any?) {
    when (value) {
        is String? -> edit { it.putString(key, value) }
        is Int -> edit { it.putInt(key, value) }
        is Boolean -> edit { it.putBoolean(key, value) }
        is Float -> edit { it.putFloat(key, value) }
        is Long -> edit { it.putLong(key, value) }
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}

/**
 * finds value on given key.
 * [T] is the type of value
 * @param defaultValue optional default value - will take null for strings, false for bool and -1 for numeric values if [defaultValue] is not specified
 */
inline operator fun <reified T : Any> SharedPreferences.get(
    key: String,
    defaultValue: T? = null
): T? {
    return when (T::class) {
        String::class -> getString(key, defaultValue as? String) as T?
        Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
        Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
        Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
        Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}