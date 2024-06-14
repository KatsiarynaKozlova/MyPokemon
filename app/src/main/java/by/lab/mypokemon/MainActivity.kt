package by.lab.mypokemon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.lab.mypokemon.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:  ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pokemonNameTextView.setOnClickListener {
            val intent = Intent(this@MainActivity, DetailsActivity::class.java).apply {
                putExtra("pokemon_id", 1)/* pokemonId) */
            }
            startActivity(intent)
        }
    }
}