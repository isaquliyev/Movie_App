package com.isaquliyev.movieapp1508

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isaquliyev.movieapp1508.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {
    lateinit var binding : ActivityOnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}