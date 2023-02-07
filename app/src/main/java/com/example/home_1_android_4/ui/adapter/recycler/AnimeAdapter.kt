package com.example.home_1_android_4.ui.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.home_1_android_4.data.models.anime.AnimeData
import com.example.home_1_android_4.databinding.ItemRecyclerBinding

class AnimeAdapter(private val onClickListener: (id: String) -> Unit) :
    ListAdapter<AnimeData, AnimeAdapter.AnimeViewHolder>(diffUtil) {

    inner class AnimeViewHolder(private val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: AnimeData?) = with(binding) {
            Glide.with(imageItem.context).load(model?.attributes?.posterImage?.original)
                .into(imageItem)
            txtTitleItem.text = model?.attributes?.titles?.enJp
        }

        init {
            itemView.setOnClickListener {
                getItem(bindingAdapterPosition).apply { onClickListener(id) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            ItemRecyclerBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        getItem(position).let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<AnimeData>() {
            override fun areItemsTheSame(oldItem: AnimeData, newItem: AnimeData): Boolean {
                return oldItem.attributes.titles == newItem.attributes.titles
            }

            override fun areContentsTheSame(oldItem: AnimeData, newItem: AnimeData): Boolean {
                return oldItem == newItem
            }
        }
    }
}