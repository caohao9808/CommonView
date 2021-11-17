package org.fengye.commonview.lib.dialog

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Dialog
import android.content.Context
import android.graphics.drawable.RotateDrawable
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.TextView
import org.fengye.commonview.lib.R
import org.fengye.commonview.lib.util.runMain

/**
 * iOS风格的加载对话框
 * @param title 加载对话框的标题
 */
class BubbleDialog(
    context: Context,
    var title: String = context.getString(R.string.bubble_loading_title),
) : Dialog(context) {

    var tv_title: TextView? = null
    var iv_loading: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setContentView(R.layout.layout_bubble_dialog)

        setCancelable(false)
        setCanceledOnTouchOutside(false)

        tv_title = findViewById<TextView>(R.id.tv_title)
        iv_loading = findViewById<ImageView>(R.id.iv_loading)
        tv_title?.text = title
        val rotateDrawable = iv_loading?.background as RotateDrawable
        ObjectAnimator.ofInt(rotateDrawable, "level", 0, 10000).apply {
            duration = 2000
            repeatCount = ValueAnimator.INFINITE
            interpolator = LinearInterpolator()
            start()
        }
    }

    fun updateTitle(title: String?) {
        tv_title?.text = title
    }

    override fun show() {
        runMain {
            super.show()
        }
    }
}