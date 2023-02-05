package com.example.home_1_android_4.ui.fragments.manga

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.home_1_android_4.R
import com.example.home_1_android_4.base.BaseFragment
import com.example.home_1_android_4.databinding.FragmentMangaBinding
import com.example.home_1_android_4.ui.adapter.MangaAdapter
import com.example.home_1_android_4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val viewModel: MangaViewModel by viewModels()
    override val binding by viewBinding(FragmentMangaBinding::bind)
    private val mangaAdapter = MangaAdapter(this::onClickItem)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    override fun initialize() {
        binding.rvListManga.adapter = mangaAdapter
    }

    override fun setupSubscribes() {
        super.setupSubscribes()
        subscribeToManga()
    }

    private fun subscribeToManga() {
        viewModel.getMangaScene().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "Loading...", Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    mangaAdapter.submitList(it.data?.data)
                    Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun onClickItem(id: String) {
        findNavController().navigate(
            MangaFragmentDirections.actionMangaFragmentToMangaDetailFragment(
                id.toInt()
            )
        )
    }
}