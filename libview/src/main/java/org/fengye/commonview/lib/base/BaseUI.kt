package org.fengye.commonview.lib.base

import android.content.Context
import com.hjq.toast.ToastUtils
import com.hjq.toast.style.BlackToastStyle
import org.fengye.commonview.lib.dialog.BubbleDialog

class BaseUI() : IBaseUI {

    private lateinit var mContext: Context

    private var bubbleDialog: BubbleDialog? = null

    fun init(mContext: Context) {
        this.mContext = mContext
    }

    override fun showLoading(title: String) {
        if (bubbleDialog == null) {
            bubbleDialog = BubbleDialog(mContext, title)
        } else {
            bubbleDialog?.updateTitle(title)
        }

        if (bubbleDialog?.isShowing == true) {
            bubbleDialog?.updateTitle(title)
        } else {
            bubbleDialog?.show()
        }
    }

    override fun updateLoading(title: String?) {
        if (bubbleDialog != null && bubbleDialog!!.isShowing) {
            bubbleDialog?.updateTitle(title)
        }
    }

    override fun hideLoading() {
        if (bubbleDialog != null && bubbleDialog!!.isShowing) {
            bubbleDialog!!.dismiss()
        }
    }

    override fun toast(msg: String?) {
        ToastUtils.setStyle(BlackToastStyle())
        ToastUtils.show(msg)
    }

}