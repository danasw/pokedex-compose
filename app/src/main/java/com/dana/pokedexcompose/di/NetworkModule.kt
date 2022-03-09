package com.dana.pokedexcompose.di

import com.dana.pokedexcompose.network.PokemonService
import com.dana.pokedexcompose.network.model.PokemonDtoMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun providePokemonMapper(): PokemonDtoMapper{
        return PokemonDtoMapper()
    }

    @Singleton
    @Provides
    fun providePokemonService(): PokemonService{
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(PokemonService::class.java)
    }
}