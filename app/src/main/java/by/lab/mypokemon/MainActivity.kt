package by.lab.mypokemon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.lab.mypokemon.databinding.ActivityMainBinding
import by.lab.mypokemon.recycler.adapter.PokemonListAdapter
import by.lab.mypokemon.repository.PokemonRepository


class MainActivity : AppCompatActivity() {
    private lateinit var binding:  ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PokemonListAdapter()
        adapter.onClick = { pokemon ->
            val intent = Intent(this@MainActivity, DetailsActivity::class.java).apply {
                putExtra("pokemon_id",  pokemon.id)
            }
            startActivity(intent)
        }
        adapter.submit(PokemonRepository.getAllPokemons())
        binding.recycler.adapter = adapter
    }
}