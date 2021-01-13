package com.android.demoactivityforresult.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.demoactivityforresult.R


class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        title = "Fragment"
    }
}