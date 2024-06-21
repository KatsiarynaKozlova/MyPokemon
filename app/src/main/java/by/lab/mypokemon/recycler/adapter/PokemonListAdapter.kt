package by.lab.mypokemon.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.lab.mypokemon.databinding.ItemPokemonBinding
import by.lab.mypokemon.model.Pokemon
import by.lab.mypokemon.recycler.viewholder.PokemonViewHolder

class PokemonListAdapter: RecyclerView.Adapter<PokemonViewHolder>() {
    private var items = emptyList<Pokemon>()
    var onClick: (Pokemon) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun submit(newItems: List<Pokemon>){
        items = newItems
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(items[position], onClick)
    }
}