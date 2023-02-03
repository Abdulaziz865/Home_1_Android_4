package com.example.home_1_android_4.ui.fragments.first

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.home_1_android_4.R
import com.example.home_1_android_4.databinding.FragmentFirstBinding
import com.example.home_1_android_4.ui.adapter.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : Fragment(R.layout.fragment_first) {

    private val viewModel: FirstViewModel by viewModels()
    private val binding by viewBinding(FragmentFirstBinding::bind)
    private val animeAdapter = AnimeAdapter(this::onClickItem)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpObserves()
    }

    private fun initialize() {
        binding.rvList.adapter = animeAdapter
    }

    private fun setUpObserves() {
        viewModel.getAnimeScene().observe(viewLifecycleOwner) {
            animeAdapter.submitList(it.data)
        }
    }

    private fun onClickItem(id: String) {
        findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToDetailFragment(id.toInt()))
    }
}