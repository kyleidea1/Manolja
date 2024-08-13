package com.example.manolja

import android.app.Application
import android.util.Log
import com.sendbird.android.SendbirdChat
import com.sendbird.android.exception.SendbirdException
import com.sendbird.android.handler.InitResultHandler
import com.sendbird.android.params.InitParams

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        SendbirdChat.init(
            InitParams("APP_ID", applicationContext, useCaching = true).apply {
                // let SDK know it's called from foreground
                isForeground = true
            },
            object : InitResultHandler {
                override fun onMigrationStarted() {
                    Log.i("Application", "Called when there's an update in Sendbird server.")
                }

                override fun onInitFailed(e: SendbirdException) {
                    Log.i("Application", "Called when initialize failed. SDK will still operate properly as if useLocalCaching is set to false.")
                }

                override fun onInitSucceed() {
                    Log.i("Application", "Called when initialization is completed.")
                }
            }
        )
    }
}