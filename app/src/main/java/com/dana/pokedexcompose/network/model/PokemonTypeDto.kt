package com.dana.pokedexcompose.network.model

import com.google.gson.annotations.SerializedName

data class PokemonTypeDto(
    @SerializedName("pokemon")
    var pokemon: PokemonByType,
)

data class PokemonByType (
    @SerializedName("name" )
    var name : String,
    @SerializedName("url"  )
    var url  : String,
)


