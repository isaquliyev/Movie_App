package com.isaquliyev.movieapp1508.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.isaquliyev.movieapp1508.R
import com.isaquliyev.movieapp1508.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.fragmentContainerView)


        binding.bottomBar.setupWithNavController(navController)

        binding.bottomBar.onItemSelected = {
//            status.text = "Item $it selected"

        }

        binding.bottomBar.onItemReselected = {
//            status.text = "Item $it re-selected"
        }
    }



}