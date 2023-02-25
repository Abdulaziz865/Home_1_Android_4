package com.example.home_1_android_4.ui.fragments.anime

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.home_1_android_4.R
import com.example.home_1_android_4.base.BaseFragment
import com.example.home_1_android_4.databinding.FragmentAnimeBinding
import com.example.home_1_android_4.ui.adapters.AnimeAdapter
import com.example.home_1_android_4.ui.fragments.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

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
            lifecycleScope.launch {
                animeAdapter.submitData(it)
            }
        }
    }

    private fun onClickItem(id: String) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragment2ToAnimeDetailFragment(id.toInt()))
    }
}