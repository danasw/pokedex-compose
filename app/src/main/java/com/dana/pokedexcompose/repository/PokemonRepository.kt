package com.dana.pokedexcompose.repository

import com.dana.pokedexcompose.domain.model.Pokemon

interface PokemonRepository {
    suspend fun fetchPokemonList(): List<Pokemon>

    suspend fun fetchPokemonInfo(name: String): Pokemon
}