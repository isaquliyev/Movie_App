package com.isaquliyev.movieapp1508.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isaquliyev.movieapp1508.ui.home.HomeActivity
import com.isaquliyev.movieapp1508.databinding.ActivityOnboardingBinding
import com.isaquliyev.movieapp1508.ui.signin_signup.SigninSignupActivity

class OnboardingActivity : AppCompatActivity() {
    lateinit var binding : ActivityOnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.viewPager.adapter = OnboardViewPagerAdapter(supportFragmentManager)
        binding.onboardDotsIndicator.setViewPager(binding.viewPager)

        binding.nextButton.setOnClickListener {
            if(binding.viewPager.currentItem==2){
                //intent
                val intent = Intent(this, SigninSignupActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                binding.viewPager.setCurrentItem(getItem(+1), true)
            }
        }
    }

    private fun getItem(i : Int):Int{
        return binding.viewPager.getCurrentItem() + i;
    }
}