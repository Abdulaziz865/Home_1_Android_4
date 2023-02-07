package com.example.home_1_android_4.ui.fragments.home

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.home_1_android_4.R
import com.example.home_1_android_4.base.BaseFragment
import com.example.home_1_android_4.base.BaseViewModel
import com.example.home_1_android_4.databinding.FragmentHomeBinding
import com.example.home_1_android_4.ui.adapter.home_adapter.HomeAdapter
import com.example.home_1_android_4.ui.fragments.anime.AnimeFragment
import com.example.home_1_android_4.ui.fragments.manga.MangaFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, BaseViewModel>(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel by viewModels<BaseViewModel>()

    override fun initialize() {
        tabLayout()
    }

    private fun tabLayout() {
        val homeAdapter = HomeAdapter(childFragmentManager)
        homeAdapter.addFragment(AnimeFragment(), "Anime")
        homeAdapter.addFragment(MangaFragment(), "Manga")
        binding.viewPager.adapter = homeAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}