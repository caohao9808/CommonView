package org.fengye.commonview.lib.base

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.hjq.toast.ToastUtils
import com.hjq.toast.style.BlackToastStyle
import org.fengye.commonview.lib.dialog.BubbleDialog

class BaseFragmentUI() : IBaseUI {

    private lateinit var mActivity: FragmentActivity

    private val baseUI: IBaseUI?
        get() =
            if (mActivity is IBaseUI)
                mActivity as IBaseUI
            else
                null

    override fun initBaseUI(mActivity: FragmentActivity) {
        super.initBaseUI(mActivity)
        this.mActivity = mActivity
    }

    override fun showLoading(title: String) {
        baseUI?.showLoading(title)
    }

    override fun updateLoading(title: String?) {
        baseUI?.updateLoading(title)
    }

    override fun hideLoading() {
        baseUI?.hideLoading()
    }

    override fun toast(msg: String?) {
        baseUI?.toast(msg)
    }
}