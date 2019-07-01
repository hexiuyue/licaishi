package com.guoshi.module_news

import android.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.guoshi.baselib.base.BaseActivity
import com.guoshi.module_news.databinding.FragmentOptionalBinding


/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：消息fragment
 */
class OptionalFragment : Fragment() {
    private var binding: FragmentOptionalBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_optional, container, false)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding!!.wdln.setPadding(0, BaseActivity.getstatusbar(activity!!), 0, 0)
        }
        return binding!!.root
    }

}
