package org.fengye.commonview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenCreated
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.fengye.commonview.databinding.ActivityMainBinding
import org.fengye.commonview.lib.base.BaseUI
import org.fengye.commonview.lib.base.IBaseUI
import org.fengye.commonview.lib.scrollpicker.DatePickerAdapter
import org.fengye.commonview.lib.scrollpicker.PickAdapter

class MainActivity : AppCompatActivity(), IBaseUI by BaseUI() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBaseUI(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.yearPicker.setAdapter(DatePickerAdapter(1, 10))
        binding.toast.setOnClickListener {
            toast("toast")
        }

        supportFragmentManager.commit {
            replace(R.id.container, BlankFragment.newInstance())
        }

        binding.loading.setOnClickListener {
            showLoading()
            lifecycleScope.launch {
                delay(2000)
                updateLoading("update")
                delay(2000)
                hideLoading()
            }
        }

        binding.codeBtn.setNormalText("获取验证码")
            .setCountDownText("", "")
            .setCloseKeepCountDown(true)//关闭页面保持倒计时开关
            .setCountDownClickable(false)//倒计时期间点击事件是否生效开关
            .setShowFormatTime(true)//是否格式化时间
            .setOnClickListener {
                lifecycleScope.launch {
                    showLoading()
                    delay(1000)
                    hideLoading()
                    toast("发送成功")
                    binding.codeBtn.startCountDown(59)
                }

            }

    }
}