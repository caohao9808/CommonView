package org.fengye.commonview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.fengye.commonview.databinding.FragmentBlankBinding
import org.fengye.commonview.lib.base.BaseFragmentUI
import org.fengye.commonview.lib.base.BaseUI
import org.fengye.commonview.lib.base.IBaseUI


class BlankFragment : Fragment(), IBaseUI by BaseFragmentUI() {

    private lateinit var binding: FragmentBlankBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentBlankBinding.inflate(inflater, container, false)
        initView(savedInstanceState)
        return binding.root
    }

    private fun initView(savedInstanceState: Bundle?) {
        initBaseUI(requireActivity())
        binding.test.setOnClickListener {
            toast("hhh")
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}