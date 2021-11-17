package org.fengye.commonview.lib

import androidx.databinding.BindingAdapter
import org.fengye.commonview.lib.starview.StarView

class CustomViewBindingUtil {
    companion object {
        @JvmStatic
        @BindingAdapter("starViewMark")
        fun setStartViewMark(startView: StarView, starViewMark: Float = 0f) {
            startView.mark = starViewMark
        }
    }

}