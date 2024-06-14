package by.lab.mypokemon.model

import android.graphics.Picture

data class Pokemon(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val elementalType: List<String>,
    val picture: Int
)
