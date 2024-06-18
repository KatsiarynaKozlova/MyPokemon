package by.lab.mypokemon.repository

import by.lab.mypokemon.R
import by.lab.mypokemon.model.Pokemon

object PokemonRepository {
    private val pokemons: HashMap<Int, Pokemon> = hashMapOf(
        1 to
        Pokemon(
            id = 1,
            name = "Bulbasaur",
            weight = 69,
            height = 7,
            elementalType = listOf("Grass","Poison"),
            picture = R.drawable.bulbasaur
        ),
        2 to
        Pokemon(
            id = 2,
            name = "Ivysaur",
            weight = 130,
            height = 10,
            elementalType = listOf("Grass","Poison"),
            picture = R.drawable.ivysaur
        ),
        3 to
        Pokemon(
            id = 3,
            name = "Venusaur",
            weight = 1000,
            height = 20,
            elementalType = listOf("Grass","Poison"),
            picture = R.drawable.venusaur
        ),
        4 to
        Pokemon(
            id = 4,
            name = "Charmander",
            weight = 85,
            height = 6,
            elementalType = listOf("Fire"),
            picture = R.drawable.charmander
        ),
        5 to
        Pokemon(
            id = 5,
            name = "Charmeleon",
            weight = 190,
            height = 11,
            elementalType = listOf("Fire"),
            picture = R.drawable.charmeleon
        ),
        6 to
        Pokemon(
            id = 6,
            name = "Charizard",
            weight = 905,
            height = 17,
            elementalType = listOf("Fire","Flying"),
            picture = R.drawable.charizard
        ),
        7 to
        Pokemon(
            id = 7,
            name = "Squirtle",
            weight = 90,
            height = 5,
            elementalType = listOf("Water"),
            picture = R.drawable.squirtle
        ),
        8 to
        Pokemon(
            id = 8,
            name = "Wartortle",
            weight = 225,
            height = 10,
            elementalType = listOf("Water"),
            picture = R.drawable.wartortle
        ),
        9 to
        Pokemon(
            id = 9,
            name = "Blastoise",
            weight = 855,
            height = 16,
            elementalType = listOf("Water"),
            picture = R.drawable.blastoise
        ),
        10 to
        Pokemon(
            id = 10,
            name = "Caterpie",
            weight = 29,
            height = 3,
            elementalType = listOf("Bug"),
            picture = R.drawable.caterpie
        )
    )
    fun getAllPokemons(): MutableCollection<Pokemon> {
        return pokemons.values
    }
    fun getPokemonById(id: Int) = pokemons[id]
}
