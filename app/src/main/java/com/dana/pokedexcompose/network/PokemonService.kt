package com.dana.pokedexcompose.network

import com.dana.pokedexcompose.network.model.PokemonDto
import com.dana.pokedexcompose.network.response.PokemonResponse
import com.dana.pokedexcompose.network.response.PokemonTypeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int
    ): PokemonResponse

    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(
        @Path("name") name: String
    ): PokemonDto

    @GET("type/{type}")
    suspend fun fetchPokemonByType(
        @Path("type") type: Int
    ): PokemonTypeResponse
}