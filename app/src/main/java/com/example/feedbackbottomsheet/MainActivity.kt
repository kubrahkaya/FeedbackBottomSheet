package com.example.feedbackbottomsheet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.feedbackbottomsheet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.showBottomSheet.setOnClickListener {
            FeedbackBottomSheet().show(
                supportFragmentManager,
                FeedbackBottomSheet.TAG
            )
        }
    }
}