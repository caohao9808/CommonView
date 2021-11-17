package org.fengye.commonview.lib.base

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.hjq.toast.ToastUtils
import com.hjq.toast.style.BlackToastStyle
import org.fengye.commonview.lib.dialog.BubbleDialog

class BaseFragmentUI() : IBaseUI {

    private lateinit var mActivity: FragmentActivity

    override fun initBaseUI(mActivity: FragmentActivity) {
        super.initBaseUI(mActivity)
        this.mActivity = mActivity
    }

    override fun showLoading(title: String) {
        if (mActivity is IBaseUI) {
            (mActivity as IBaseUI).showLoading(title)
        }
    }

    override fun updateLoading(title: String?) {
        if (mActivity is IBaseUI) {
            (mActivity as IBaseUI).updateLoading(title)
        }
    }

    override fun hideLoading() {
        if (mActivity is IBaseUI) {
            (mActivity as IBaseUI).hideLoading()
        }
    }

    override fun toast(msg: String?) {
        if (mActivity is IBaseUI) {
            (mActivity as IBaseUI).toast(msg)
        }
    }
}