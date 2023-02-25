package com.example.home_1_android_4.ui.fragments.anime.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.home_1_android_4.R
import com.example.home_1_android_4.base.BaseFragment
import com.example.home_1_android_4.databinding.FragmentAnimeDetailBinding
import com.example.home_1_android_4.extensions.toast
import com.example.home_1_android_4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment :
    BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>(R.layout.fragment_anime_detail) {

    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    private val navArgs by navArgs<AnimeDetailFragmentArgs>()
    override val viewModel: AnimeDetailViewModel by viewModels()

    override fun setupSubscribes() {
        subscribeToAnimeDetail()
    }

    private fun subscribeToAnimeDetail() = with(binding) {
        viewModel.fetchAnimeById(navArgs.id).subscribe(
            onFailure = {
                toast(it)
            },
            onSuccess = {
                it.data.let {
                    Glide.with(imageItemDetailAnime.context).load(it.attributes.posterImage.original)
                        .into(imageItemDetailAnime)
                    titleItemDetailAnime.text = it.attributes.titles.enJp
                }
            }
        )
    }
}