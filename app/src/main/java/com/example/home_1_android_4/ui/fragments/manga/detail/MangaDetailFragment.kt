package com.example.home_1_android_4.ui.fragments.manga.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.home_1_android_4.R
import com.example.home_1_android_4.base.BaseFragment
import com.example.home_1_android_4.databinding.FragmentMangaDetailBinding
import com.example.home_1_android_4.extensions.toast
import com.example.home_1_android_4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment :
    BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>(R.layout.fragment_manga_detail) {

    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
    private val navArgs by navArgs<MangaDetailFragmentArgs>()
    override val viewModel: MangaDetailViewModel by viewModels()

    override fun setupSubscribes() {
        subscribeToMangaDetail()
    }

    private fun subscribeToMangaDetail() = with(binding) {
        viewModel.fetchMangaById(navArgs.id).subscribe(
            onFailure = {
                toast(it)
            },
            onSuccess = {
                it.data.let {
                    Glide.with(imageItemDetailManga.context).load(it.attributes.posterImageManga.original)
                        .into(imageItemDetailManga)
                    titleItemDetailManga.text = it.attributes.titles.enJp
                }
            }
        )
    }
}