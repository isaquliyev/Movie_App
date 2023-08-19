package com.isaquliyev.movieapp1508.ui.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.isaquliyev.movieapp1508.R
import com.isaquliyev.movieapp1508.adapter.CategoriesAdapter
import com.isaquliyev.movieapp1508.adapter.PopularAdapter
import com.isaquliyev.movieapp1508.adapter.TopAdapter
import com.isaquliyev.movieapp1508.databinding.FragmentHomeBinding
import com.isaquliyev.movieapp1508.model.CategoriesItem
import com.isaquliyev.movieapp1508.model.PopularItem
import com.isaquliyev.movieapp1508.model.TopItem

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var viewPager2: ViewPager2
    lateinit var categories: RecyclerView
    lateinit var popular: RecyclerView
    lateinit var topList: ArrayList<TopItem>
    lateinit var categoryList: List<CategoriesItem>
    lateinit var popularList: List<PopularItem>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater)
        viewPager2 = binding.viewPager2
        categories = binding.categories
        popular = binding.popular
        topList = arrayListOf()
        categoryList = listOf()
        popularList = listOf()

        viewPager2.adapter = TopAdapter(requireContext(), topList)

        categories.setHasFixedSize(true)
        categories.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        categories.adapter = CategoriesAdapter(requireContext(), categoryList)

        popular.setHasFixedSize(true)
        popular.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        popular.adapter = PopularAdapter(requireContext(), popularList)

        return binding.root
    }
}