package by.lab.mypokemon

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
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
              //  binding.pokemonTypeListView
            } else {
              // Pokemon not found
            }
        } else {
            //Invalid id
        }
        binding.backBtn.setOnClickListener{
            val intent = Intent(this@DetailsActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
