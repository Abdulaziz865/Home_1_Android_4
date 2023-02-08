package com.example.home_1_android_4.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.home_1_android_4.ui.fragments.anime.AnimeFragment
import com.example.home_1_android_4.ui.fragments.manga.MangaFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                AnimeFragment()
            }
            else -> {
                MangaFragment()
            }
        }
    }
}