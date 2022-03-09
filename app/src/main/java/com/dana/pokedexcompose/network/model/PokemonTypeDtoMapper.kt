package com.dana.pokedexcompose.network.model

import com.dana.pokedexcompose.domain.model.Pokemon
import com.dana.pokedexcompose.domain.util.DomainMapper

class PokemonTypeDtoMapper : DomainMapper<PokemonTypeDto, Pokemon>{

    override fun mapToDomainModel(model: PokemonTypeDto): Pokemon {
        return Pokemon(
            name = model.pokemon.name,
            url = model.pokemon.url,
        )
    }

    fun toDomainList(initial: List<PokemonTypeDto>): List<Pokemon>{
        return initial.map { mapToDomainModel(it) }
    }

    override fun mapFromDomainModel(domainModel: Pokemon): PokemonTypeDto {
        TODO("Not yet implemented")
    }

}