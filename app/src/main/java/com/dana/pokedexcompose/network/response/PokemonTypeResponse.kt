package com.dana.pokedexcompose.network.response

import com.dana.pokedexcompose.network.model.PokemonTypeDto
import com.google.gson.annotations.SerializedName

data class PokemonTypeResponse(
    @SerializedName("pokemon")
    var pokemonByType: List<PokemonTypeDto>
)
