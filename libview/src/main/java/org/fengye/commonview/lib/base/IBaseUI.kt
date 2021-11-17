package org.fengye.commonview.lib.base

interface IBaseUI {
    fun showLoading(title: String = "加载中")

    fun updateLoading(title: String?)

    fun hideLoading()

    fun toast(msg: String?)
}