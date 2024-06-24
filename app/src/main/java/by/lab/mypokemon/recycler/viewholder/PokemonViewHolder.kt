package by.lab.mypokemon.recycler.viewholder

import androidx.recyclerview.widget.RecyclerView
import by.lab.mypokemon.databinding.ItemPokemonBinding
import by.lab.mypokemon.model.Pokemon

class PokemonViewHolder(
    private val binding: ItemPokemonBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(model: Pokemon, onClick: (Pokemon) -> Unit){
        binding.pokemonNameTextView.text = model.name
        binding.pokemonImageView.setImageResource(model.picture)
        binding.root.setOnClickListener{ onClick(model) }
    }
}