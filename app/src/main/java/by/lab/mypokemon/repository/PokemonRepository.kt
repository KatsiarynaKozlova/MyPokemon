package by.lab.mypokemon.repository

import by.lab.mypokemon.R
import by.lab.mypokemon.model.Pokemon

object PokemonRepository {
    private val pokemons: List<Pokemon> = listOf(
        Pokemon(
            id = 1,
            name = "Bulbasaur",
            weight = 69,
            height = 7,
            elementalType = listOf("Grass","Poison"),
            picture = R.drawable.bulbasaur
        ),
        Pokemon(
            id = 2,
            name = "Ivysaur",
            weight = 130,
            height = 10,
            elementalType = listOf("Grass","Poison"),
            picture = R.drawable.ivysaur
        ),
        Pokemon(
            id = 3,
            name = "Venusaur",
            weight = 1000,
            height = 20,
            elementalType = listOf("Grass","Poison"),
            picture = R.drawable.venusaur
        ),
        Pokemon(
            id = 4,
            name = "Charmander",
            weight = 85,
            height = 6,
            elementalType = listOf("Fire"),
            picture = R.drawable.charmander
        ),
        Pokemon(
            id = 5,
            name = "Charmeleon",
            weight = 190,
            height = 11,
            elementalType = listOf("Fire"),
            picture = R.drawable.charmeleon
        ),
        Pokemon(
            id = 6,
            name = "Charizard",
            weight = 905,
            height = 17,
            elementalType = listOf("Fire","Flying"),
            picture = R.drawable.charizard
        ),
        Pokemon(
            id = 7,
            name = "Squirtle",
            weight = 90,
            height = 5,
            elementalType = listOf("Water"),
            picture = R.drawable.squirtle
        ),
        Pokemon(
            id = 8,
            name = "Wartortle",
            weight = 225,
            height = 10,
            elementalType = listOf("Water"),
            picture = R.drawable.wartortle
        ),
        Pokemon(
            id = 9,
            name = "Blastoise",
            weight = 855,
            height = 16,
            elementalType = listOf("Water"),
            picture = R.drawable.blastoise
        ),
        Pokemon(
            id = 10,
            name = "Caterpie",
            weight = 29,
            height = 3,
            elementalType = listOf("Bug"),
            picture = R.drawable.caterpie
        )
    )
    fun getAllPokemons(): List<Pokemon>{
        return pokemons
    }
    fun getPokemonById(id: Int): Pokemon?{
        return pokemons.find { it.id == id }
    }
}