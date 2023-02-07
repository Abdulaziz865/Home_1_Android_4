package com.example.home_1_android_4.ui.fragments.manga

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.home_1_android_4.R
import com.example.home_1_android_4.base.BaseFragment
import com.example.home_1_android_4.databinding.FragmentMangaBinding
import com.example.home_1_android_4.extensions.toast
import com.example.home_1_android_4.ui.adapter.recycler.MangaAdapter
import com.example.home_1_android_4.ui.fragments.anime.AnimeFragment
import com.example.home_1_android_4.ui.fragments.home.HomeFragmentDirections
import com.example.home_1_android_4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val viewModel: MangaViewModel by viewModels()
    override val binding by viewBinding(FragmentMangaBinding::bind)
    private val mangaAdapter = MangaAdapter(this::onClickItem)

    override fun initialize() {
        binding.rvListManga.adapter = mangaAdapter
    }

    override fun setupSubscribes() {
        subscribeToManga()
    }

    private fun subscribeToManga() {
        viewModel.fetchManga().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Failure -> {
                    toast(it.message)
                }
                is Resource.Loading -> {
                    toast("Loading...")
                }
                is Resource.Success -> {
                    mangaAdapter.submitList(it.data?.data)
                    toast("Success")
                }
            }
        }
    }

    private fun onClickItem(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToMangaDetailFragment(
                id.toInt()
            )
        )
    }
}