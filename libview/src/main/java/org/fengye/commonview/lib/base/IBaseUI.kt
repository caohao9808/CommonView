package org.fengye.commonview.lib.base

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentActivity

interface IBaseUI {

    fun initBaseUI(mActivity: FragmentActivity) {

    }

    fun showLoading(title: String = "加载中")

    fun updateLoading(title: String?)

    fun hideLoading()

    fun toast(msg: String?, @LayoutRes layoutRes: Int? = null)
}