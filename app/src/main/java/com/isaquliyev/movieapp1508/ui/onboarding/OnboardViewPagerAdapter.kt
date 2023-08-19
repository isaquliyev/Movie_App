package com.isaquliyev.movieapp1508.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.isaquliyev.movieapp1508.ui.onboarding.fragment.OnboardingElement1
import com.isaquliyev.movieapp1508.ui.onboarding.fragment.OnboardingElement2
import com.isaquliyev.movieapp1508.ui.onboarding.fragment.OnboardingElement3

class OnboardViewPagerAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return OnboardingElement1()
            }
            1 -> {
                return OnboardingElement2()
            }
            2 -> {
                return OnboardingElement3()
            }
            else -> {
                return OnboardingElement1()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return super.getPageTitle(position)
    }

}