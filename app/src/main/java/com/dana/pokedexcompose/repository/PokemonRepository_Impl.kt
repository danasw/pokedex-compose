package com.dana.pokedexcompose.repository

import com.dana.pokedexcompose.domain.model.Pokemon
import com.dana.pokedexcompose.network.PokemonService
import com.dana.pokedexcompose.network.model.PokemonDtoMapper
import com.dana.pokedexcompose.network.model.PokemonTypeDtoMapper

class PokemonRepository_Impl(
    private val pokemonService: PokemonService,
    private val mapper: PokemonDtoMapper,
    private val typeMapper: PokemonTypeDtoMapper,
):PokemonRepository {

    override suspend fun fetchPokemonList(limit: Int): List<Pokemon> {
        return mapper.toDomainList(pokemonService.fetchPokemonList(limit).pokemons)
    }

    override suspend fun fetchPokemonInfo(name: String): Pokemon {
        return mapper.mapToDomainModel(pokemonService.fetchPokemonInfo(name))
    }

    override suspend fun fetchPokemonByType(type: Int): List<Pokemon> {
        return typeMapper.toDomainList(pokemonService.fetchPokemonByType(type).pokemonByType)
    }
}