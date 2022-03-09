package com.dana.pokedexcompose.repository

import com.dana.pokedexcompose.domain.model.Pokemon

interface PokemonRepository {
    suspend fun fetchPokemonList(limit: Int): List<Pokemon>

    suspend fun fetchPokemonInfo(name: String): Pokemon

    suspend fun fetchPokemonByType(type: Int): List<Pokemon>
}