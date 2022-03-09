package com.dana.pokedexcompose.network.model

import com.google.gson.annotations.SerializedName

data class PokemonDto(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String,
)