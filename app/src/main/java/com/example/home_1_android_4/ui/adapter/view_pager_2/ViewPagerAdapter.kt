package com.example.home_1_android_4.ui.adapter.view_pager_2

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.home_1_android_4.ui.fragments.anime.AnimeFragment
import com.example.home_1_android_4.ui.fragments.manga.MangaFragment

class ViewPagerAdapter(activity: AppCompatActivity) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                AnimeFragment()
            }
            1 -> {
                MangaFragment()
            }
            else -> {
                AnimeFragment()
            }
        }
    }
}