package com.example.myapplication.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.PokemonData
import com.example.myapplication.databinding.PokemonListItemBinding

object PokemonListPresenter {

    @BindingAdapter("bindPokemonList")
    @JvmStatic
    fun RecyclerView.bindItems(items: List<PokemonData>?) {
        items?.let {
            val adapter = adapter as PokemonListAdapter
            adapter.submitList(it)
        }
    }

    class PokemonListAdapter: ListAdapter<PokemonData, PokemonListAdapter.PokemonListViewHolder>(PokemonDataDiffCallback()){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PokemonListViewHolder.from(parent)

        override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) = holder.bind(getItem(position))

        class PokemonListViewHolder(private val binding: PokemonListItemBinding): RecyclerView.ViewHolder(binding.root) {

            fun bind(item: PokemonData) {
                binding.pokemonData = item
                binding.executePendingBindings()
            }

            companion object {
                fun from(parent: ViewGroup): PokemonListViewHolder {
                    val layoutInflater = LayoutInflater.from(parent.context)
                    val binding = PokemonListItemBinding.inflate(layoutInflater, parent, false)
                    return PokemonListViewHolder(binding)
                }
            }
        }
    }
    class PokemonDataDiffCallback : DiffUtil.ItemCallback<PokemonData>() {
        override fun areItemsTheSame(oldItem: PokemonData, newItem: PokemonData) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: PokemonData, newItem: PokemonData) = oldItem == newItem
    }
}