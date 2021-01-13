package com.android.demoactivityforresult.fragment

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.android.demoactivityforresult.SecondActivity

/**
 * Created by NguyenLinh on 13,January,2021
 * If you care lifecycle
 *
Use:
lateinit var observer: MyLifecycleObserver
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observer = MyLifecycleObserver(requireActivity().activityResultRegistry)
        lifecycle.addObserver(observer)
        observer.startSecondActivity(requireActivity())
}
 *
 */
class MyLifecycleObserver(private val registry: ActivityResultRegistry) : DefaultLifecycleObserver {
    lateinit var getIntent: ActivityResultLauncher<Intent>
    override fun onCreate(owner: LifecycleOwner) {
        getIntent = registry.register("KEY_NAME", owner, ActivityResultContracts.StartActivityForResult()) {result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val nickName = result.data?.getStringExtra("KEY_NAME")
            }
        }
    }

    fun startSecondActivity(activity: Activity){
        val intent = Intent(activity, SecondActivity::class.java)
        getIntent.launch(intent)
    }
}