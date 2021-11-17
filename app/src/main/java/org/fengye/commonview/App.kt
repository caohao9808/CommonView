package org.fengye.commonview

import android.app.Application
import org.fengye.commonview.lib.base.CommonApp

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        CommonApp.init(this)
    }

}