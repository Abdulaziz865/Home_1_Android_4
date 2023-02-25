package com.example.home_1_android_4.ui.fragments.manga

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.home_1_android_4.R
import com.example.home_1_android_4.base.BaseFragment
import com.example.home_1_android_4.databinding.FragmentMangaBinding
import com.example.home_1_android_4.ui.adapters.MangaAdapter
import com.example.home_1_android_4.ui.fragments.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
            lifecycleScope.launch {
                mangaAdapter.submitData(it)
            }
        }
    }

    private fun onClickItem(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragment2ToMangaDetailFragment2(id.toInt())
        )
    }
}