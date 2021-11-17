package org.fengye.commonview.lib.base

import android.app.Application
import com.hjq.toast.ToastUtils

object CommonApp {

    private lateinit var app: Application

    fun init(app: Application) {
        this.app = app
        ToastUtils.init(app)
    }

}