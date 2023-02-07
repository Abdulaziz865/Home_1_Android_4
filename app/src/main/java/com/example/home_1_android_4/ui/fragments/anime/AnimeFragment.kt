package com.example.home_1_android_4.ui.fragments.anime

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.home_1_android_4.R
import com.example.home_1_android_4.base.BaseFragment
import com.example.home_1_android_4.databinding.FragmentAnimeBinding
import com.example.home_1_android_4.extensions.toast
import com.example.home_1_android_4.ui.adapter.recycler.AnimeAdapter
import com.example.home_1_android_4.ui.adapter.view_pager_2.ViewPagerAdapter
import com.example.home_1_android_4.ui.fragments.home.HomeFragmentDirections
import com.example.home_1_android_4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment(
) : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(this::onClickItem)

    override fun initialize() {
        binding.rvList.adapter = animeAdapter
    }

    override fun setupSubscribes() {
        subscribeToAnime()
    }

    private fun subscribeToAnime() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Failure -> {
                    toast(it.message)
                }
                is Resource.Loading -> {
                    toast("Loading...")
                }
                is Resource.Success -> {
                    animeAdapter.submitList(it.data?.data)
                    toast("Success")
                }
            }
        }
    }

    private fun onClickItem(id: String) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(id.toInt()))
    }
}