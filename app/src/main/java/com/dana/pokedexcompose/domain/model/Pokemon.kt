package com.dana.pokedexcompose.domain.model

data class Pokemon(
    val name: String,
    val url: String,
) {
    fun getImgUrl(): String{
        val index = url.split("/".toRegex()).dropLast(1).last()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
    }
}
