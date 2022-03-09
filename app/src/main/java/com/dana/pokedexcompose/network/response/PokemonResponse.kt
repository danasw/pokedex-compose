package com.dana.pokedexcompose.network.response

import com.dana.pokedexcompose.network.model.PokemonDto
import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var pokemons: List<PokemonDto>,
)
