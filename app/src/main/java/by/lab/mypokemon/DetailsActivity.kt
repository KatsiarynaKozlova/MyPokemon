package by.lab.mypokemon

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.lab.mypokemon.databinding.ActivityDetailsBinding
import by.lab.mypokemon.repository.PokemonRepository

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemonId = intent.extras?.getInt("pokemon_id", -1) ?: -1
        if (pokemonId != -1) {
            val pokemon = PokemonRepository.getPokemonById(pokemonId)
            if (pokemon != null) {
                binding.pokemonImageView.setImageResource(pokemon.picture)
                binding.pokemonNameTextView.text = pokemon.name
                binding.pokemonWeightTextView.text = pokemon.weight.toString()
                binding.pokemonHeightTextView.text = pokemon.height.toString()
                val adapter = ArrayAdapter(this@DetailsActivity, android.R.layout.simple_list_item_1, pokemon.elementalType )
                binding.pokemonTypeListView.adapter = adapter
            } else {
                Toast.makeText(this, "Unknown error. Try again later", Toast.LENGTH_SHORT).show()
                Log.e("mainPage", "Pokemon with id not exist")
                finish()
            }
        } else {
            Toast.makeText(this, "Unknown error. Try again later", Toast.LENGTH_SHORT).show()
            Log.e("mainPage", "Invalid id")
            finish()
        }
        binding.backBtn.setOnClickListener{
            finish()
        }
    }
}
