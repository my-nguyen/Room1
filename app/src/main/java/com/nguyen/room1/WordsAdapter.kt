package com.nguyen.room1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nguyen.room1.databinding.ItemBinding

class WordsAdapter: ListAdapter<Word, WordsAdapter.ViewHolder>(WordsAdapter.Comparator()) {
    class ViewHolder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(word: String) {
            binding.text.text = word
        }

        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class Comparator: DiffUtil.ItemCallback<Word>() {
        override fun areItemsTheSame(oldItem: Word, newItem: Word) = oldItem === newItem

        override fun areContentsTheSame(oldItem: Word, newItem: Word) = oldItem.word == newItem.word
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.create(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.word)
    }
}