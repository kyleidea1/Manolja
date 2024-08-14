package com.example.manolja

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.manolja.data.api.RetrofitProvider
import com.example.manolja.data.api.apiresponse.MemberPost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import java.util.UUID
import kotlin.random.Random

class Manolja : Application() {

    companion object {
        private const val PREFS_NAME = "app_prefs"
        private const val KEY_UUID = "uuid"

        @JvmStatic
        fun getUUID(context: Context): String {
            val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            return prefs.getString(KEY_UUID, null) ?: generateAndSaveUUID(context)
        }

        private fun generateAndSaveUUID(context: Context): String {
            val uuid = UUID.randomUUID().toString()
            val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            prefs.edit().putString(KEY_UUID, uuid).apply()
            return uuid
        }

    }

    override fun onCreate() {
        super.onCreate()
        val scope = CoroutineScope(Dispatchers.Main)
        val uuid = getUUID(applicationContext)
        scope.launch {
            RetrofitProvider.memberApiService.initMember(MemberPost(uuid, "부기${generateRandomInt(1,999)}"))
        }
    }
}

fun generateRandomInt(min: Int, max: Int): Int {
    return Random.nextInt(min, max + 1) // min <= result <= max
}