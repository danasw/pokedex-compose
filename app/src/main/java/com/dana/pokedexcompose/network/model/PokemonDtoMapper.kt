package com.dana.pokedexcompose.network.model

import com.dana.pokedexcompose.domain.model.Pokemon
import com.dana.pokedexcompose.domain.util.DomainMapper

class PokemonDtoMapper : DomainMapper<PokemonDto, Pokemon>{
    override fun mapToDomainModel(model: PokemonDto): Pokemon {
        return Pokemon(
            name = model.name,
            url = model.url
        )
    }

    override fun mapFromDomainModel(domainModel: Pokemon): PokemonDto {
        return PokemonDto(
            name = domainModel.name,
            url = domainModel.url
        )
    }

    fun toDomainList(inital: List<PokemonDto>): List<Pokemon> {
        //map will loop every entry from list then execute
        return inital.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Pokemon>): List<PokemonDto>{
        return initial.map { mapFromDomainModel(it) }
    }

}