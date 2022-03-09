package com.dana.pokedexcompose.presentation.ui.pokemon_list

enum class PokemonType(val value: String){
    ALL("ALL"),
    NORMAL("NORMAL"),
    FIGHTING("FIGHTING"),
    FLYING("FLYING"),
    POISON("POISON"),
    GROUND("GROUND"),
    ROCK("ROCK"),
    BUG("BUG"),
    GHOST("GHOST"),
    STEEL("STEEL"),
    FIRE("FIRE"),
    WATER("WATER"),
    GRASS("GRASS"),
    ELECTRIC("ELECTRIC"),
    PSYCHIC("PSYCHIC"),
    ICE("ICE"),
    DRAGON("DRAGON"),
    DARK("DARK"),
    FAIRY("FAIRY"),
}

fun getAllPokemonType(): List<PokemonType>{
    return listOf(
        PokemonType.ALL,
        PokemonType.NORMAL,
        PokemonType.FIGHTING,
        PokemonType.FLYING,
        PokemonType.POISON,
        PokemonType.GROUND,
        PokemonType.ROCK,
        PokemonType.BUG,
        PokemonType.GHOST,
        PokemonType.STEEL,
        PokemonType.FIRE,
        PokemonType.WATER,
        PokemonType.GRASS,
        PokemonType.ELECTRIC,
        PokemonType.PSYCHIC,
        PokemonType.ICE,
        PokemonType.DRAGON,
        PokemonType.DARK,
        PokemonType.FAIRY,
    )
}

fun getPokemonType(value: String): PokemonType? {
    val map = PokemonType.values().associateBy(PokemonType::value)
    return map[value]
}