package com.dana.pokedexcompose.repository

import com.dana.pokedexcompose.domain.model.Pokemon
import com.dana.pokedexcompose.network.PokemonService
import com.dana.pokedexcompose.network.model.PokemonDtoMapper

class PokemonRepository_Impl(
    private val pokemonService: PokemonService,
    private val mapper: PokemonDtoMapper,
):PokemonRepository {

    override suspend fun fetchPokemonList(): List<Pokemon> {
        return mapper.toDomainList(pokemonService.fetchPokemonList(100).pokemons)
    }

    override suspend fun fetchPokemonInfo(name: String): Pokemon {
        return mapper.mapToDomainModel(pokemonService.fetchPokemonInfo(name))
    }
}