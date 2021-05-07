package com.example.myapplication.module.pokemonlist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core.pokemon.PokemonData
import com.example.core.pokemon.PokemonEvent
import com.example.myapplication.databinding.PokemonListItemBinding

class PokemonListAdapter: ListAdapter<PokemonData, PokemonListAdapter.PokemonListViewHolder>(PokemonDataDiffCallback()){

    private var onTapItem: (PokemonData) -> Unit = {}

    fun setOnTapItemCallBack(onTapItem: (PokemonData) -> Unit){
        this.onTapItem = onTapItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PokemonListViewHolder.from(parent)

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) = holder.bind(getItem(position), onTapItem)

    class PokemonListViewHolder(private val binding: PokemonListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PokemonData, onTapItem: (PokemonData) -> Unit) {
            binding.pokemonData = item
            binding.root.setOnClickListener { onTapItem(item) }
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

    class PokemonDataDiffCallback : DiffUtil.ItemCallback<PokemonData>() {
        override fun areItemsTheSame(oldItem: PokemonData, newItem: PokemonData) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: PokemonData, newItem: PokemonData) = oldItem == newItem
    }
}

@BindingAdapter("bindPokemonList")
fun RecyclerView.bindItems(items: List<PokemonData>?) {
    items?.let {
        val adapter = adapter as PokemonListAdapter
        adapter.submitList(it)
    }
}