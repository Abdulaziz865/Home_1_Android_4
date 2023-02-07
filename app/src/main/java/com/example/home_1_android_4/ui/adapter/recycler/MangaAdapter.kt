package com.example.home_1_android_4.ui.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.home_1_android_4.data.models.manga.MangaData
import com.example.home_1_android_4.databinding.ItemRecyclerBinding

class MangaAdapter(private val onClickListener: (id: String) -> Unit) :
    ListAdapter<MangaData, MangaAdapter.MangaViewHolder>(diffUtil) {

    inner class MangaViewHolder(private val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: MangaData?) = with(binding) {
            Glide.with(imageItem.context).load(model?.attributes?.posterImageManga?.original)
                .into(imageItem)
            txtTitleItem.text = model?.attributes?.titles?.enJp
        }

        init {
            itemView.setOnClickListener {
                getItem(bindingAdapterPosition).apply { onClickListener(id) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        return MangaViewHolder(
            ItemRecyclerBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        getItem(position).let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<MangaData>() {
            override fun areItemsTheSame(oldItem: MangaData, newItem: MangaData): Boolean {
                return oldItem.attributes.titles == newItem.attributes.titles
            }

            override fun areContentsTheSame(oldItem: MangaData, newItem: MangaData): Boolean {
                return oldItem == newItem
            }
        }
    }
}