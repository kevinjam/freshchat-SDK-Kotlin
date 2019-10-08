package com.kevinjanvier.freshchat

import android.app.Application
import com.freshchat.consumer.sdk.Freshchat
import com.freshchat.consumer.sdk.FreshchatConfig

class Apps :Application(){

    override fun onCreate() {
        super.onCreate()
        //Initialization Options
        val freshchatConfig = FreshchatConfig("a76f661e-e7f5-4697-b35b-0810086ea679","15c208da-01ef-4825-8ad3-3f13909527f2")
        /**
         * Enable or disable features like camera
         * capture(by specifying it in the config like below) before initialization.
         */
        freshchatConfig.isCameraCaptureEnabled = true
        freshchatConfig.isGallerySelectionEnabled = true
        Freshchat.getInstance(applicationContext).init(freshchatConfig)
    }
}