package com.android.demoactivityforresult

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "Second Activity"
        btnSetNickName.setOnClickListener {
            val nickName = edtNickName.text.toString()
            val intent = Intent()
            intent.putExtra("KEY_NAME", nickName)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}