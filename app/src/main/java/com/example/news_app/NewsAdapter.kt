package com.example.news_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.databinding.ItemNewsBinding

class NewsAdapter: ListAdapter<NewsItem, NewsAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(val binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: NewsItem){
            binding.titleTextViews.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object{
        val diffUtil= object: DiffUtil.ItemCallback<NewsItem>() {
            override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
                return oldItem === newItem //=== 3번사용하면 해시코드까지 비교
            }

            override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
                return oldItem == newItem
            }

        }
    }
}