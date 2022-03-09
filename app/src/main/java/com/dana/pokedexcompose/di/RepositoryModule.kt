package com.dana.pokedexcompose.di

import com.dana.pokedexcompose.network.PokemonService
import com.dana.pokedexcompose.network.model.PokemonDtoMapper
import com.dana.pokedexcompose.network.model.PokemonTypeDtoMapper
import com.dana.pokedexcompose.repository.PokemonRepository
import com.dana.pokedexcompose.repository.PokemonRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providePokemonRepository(
        pokemonTypeMapper: PokemonTypeDtoMapper,
        pokemonService: PokemonService,
        pokemonMapper: PokemonDtoMapper,
    ) : PokemonRepository {
        return PokemonRepository_Impl(
            pokemonService = pokemonService,
            mapper = pokemonMapper,
            typeMapper = pokemonTypeMapper,
        )
    }
}