package com.guoshi.module_attention

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.alibaba.android.arouter.facade.annotation.Route
import com.guoshi.baselib.route.ModuleAttentionUtlis
import com.guoshi.baselib.route.ModuleHomeUtlis

@Route(path = ModuleAttentionUtlis.test)
class AttentionTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attention_test)

    }
}
