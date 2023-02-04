package com.example.home_1_android_4.ui.fragments.anime.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.home_1_android_4.R
import com.example.home_1_android_4.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val navArgs by navArgs<AnimeDetailFragmentArgs>()
    private val viewModel: AnimeDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserves()
    }

    private fun setUpObserves() = with(binding) {
        viewModel.getSingleAnimeScene(navArgs.id).observe(viewLifecycleOwner) {
            Glide.with(imageItemDetail.context).load(it.data.attributes.posterImage.original)
                .into(imageItemDetail)
            titleItemDetail.text = it.data.attributes.titles.enJp
        }
    }
}