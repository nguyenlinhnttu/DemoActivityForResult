package com.android.demoactivityforresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.android.demoactivityforresult.fragment.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Main Activity"
        val getContent =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val nickName = result.data?.getStringExtra("KEY_NAME")
                    tvUserName.text = nickName
                }
            }

        btnOpenSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            getContent.launch(intent)
        }

        btnOpenFragment.setOnClickListener {
            startActivity(Intent(this, FragmentActivity::class.java))
        }
        /*
        Bonus
        val takePicture = registerForActivityResult(
            ActivityResultContracts.TakePicturePreview(),
            activityResultRegistry
        ) { bitmap: Bitmap? ->
            Log.d("takePicture", "bitmap")
        }
        takePicture.launch(null)

        val requestPermissionLauncher =
            registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted: Boolean ->
                if (isGranted) {
                    // Permission is granted. Continue the action or workflow in your
                    // app.
                } else {
                    // Explain to the user that the feature is unavailable because the
                    // features requires a permission that the user has denied. At the
                    // same time, respect the user's decision. Don't link to system
                    // settings in an effort to convince the user to change their
                    // decision.
                }
            }
         requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        */
    }
}