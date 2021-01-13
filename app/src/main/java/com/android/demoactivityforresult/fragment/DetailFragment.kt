package com.android.demoactivityforresult.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.android.demoactivityforresult.R
import com.android.demoactivityforresult.SecondActivity
import kotlinx.android.synthetic.main.fragment_detail.btnOpenSecondActivity
import kotlinx.android.synthetic.main.fragment_detail.tvUserName

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getContent =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val nickName = result.data?.getStringExtra("KEY_NAME")
                    tvUserName.text = nickName
                }
            }
        btnOpenSecondActivity.setOnClickListener {
            val intent = Intent(activity, SecondActivity::class.java)
            getContent.launch(intent)
        }
    }
}