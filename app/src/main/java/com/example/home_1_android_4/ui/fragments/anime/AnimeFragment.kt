package com.example.home_1_android_4.ui.fragments.anime

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.home_1_android_4.R
import com.example.home_1_android_4.base.BaseFragment
import com.example.home_1_android_4.databinding.FragmentAnimeBinding
import com.example.home_1_android_4.ui.adapter.AnimeAdapter
import com.example.home_1_android_4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment(
) : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(this::onClickItem)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    override fun initialize() {
        binding.rvList.adapter = animeAdapter
    }

    override fun setupSubscribes() {
        super.setupSubscribes()
        subscribeToAnime()
    }

    private fun subscribeToAnime() {
        viewModel.getAnimeScene().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "Loading...", Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    animeAdapter.submitList(it.data?.data)
                    Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun onClickItem(id: String) {
        findNavController().navigate(AnimeFragmentDirections.actionFirstFragmentToDetailFragment(id.toInt()))
    }
}