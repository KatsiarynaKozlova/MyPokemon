package by.lab.mypokemon

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import by.lab.mypokemon.R.color.white
import by.lab.mypokemon.databinding.ActivityDetailsBinding
import by.lab.mypokemon.repository.PokemonRepository

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemonId = intent.extras?.getInt("pokemon_id", -1) ?: -1

        with(binding) {
            val pokemon = PokemonRepository.getPokemonById(pokemonId)
            pokemon?.let {
                pokemonNameTextView.text = it.name
                pokemonImageView.setImageResource(it.picture)
                pokemonHeightTextView.text = "${it.height} cm"
                pokemonWeightTextView.text = "${it.weight} kg"
                createTypeListView(it.elementalType)
            } ?: run {
                Log.e("mainPage", "Pokemon with id not exist")
                Toast.makeText(this@DetailsActivity, "Unknown error. Try again later", Toast.LENGTH_SHORT).show()
                finish()
            }
            backBtn.setOnClickListener { 
                finish()
            }
        }
    }

    private fun createTypeListView(typeList: List<String>) {
        var prevViewId = binding.typeView.id
        typeList.forEach {
            val textView = TextView(this).apply {
                text = it
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 24F)
                id = View.generateViewId()
                setBackgroundColor(ContextCompat.getColor(context, white))
            }
            val layoutParams = ConstraintLayout.LayoutParams(
                0,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, 12, 0,0)
            layoutParams.topToBottom = prevViewId
            layoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            layoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            textView.layoutParams = layoutParams
            binding.main.addView(textView)
            prevViewId = textView.id
        }
    }
}
