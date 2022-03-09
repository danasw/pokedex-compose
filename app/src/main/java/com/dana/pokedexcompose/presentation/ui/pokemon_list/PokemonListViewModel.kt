package com.dana.pokedexcompose.presentation.ui.pokemon_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dana.pokedexcompose.domain.model.Pokemon
import com.dana.pokedexcompose.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel
@Inject
constructor(
    private val repository: PokemonRepository,
): ViewModel() {

    val pokemons: MutableState<List<Pokemon>> = mutableStateOf(listOf())
    val selectedType: MutableState<PokemonType?> = mutableStateOf(null)
    var typeScrollPosition: Float = 0f
    val loading = mutableStateOf(false)

    init {
        newFetchPokemonList()
    }

    fun newFetchPokemonList(){
        viewModelScope.launch {
            val result= repository.fetchPokemonList(21)
            pokemons.value = result
        }
    }

    fun pokemonByType(type: String){
        viewModelScope.launch {
            var number: Int = 1
            when(type){
                "NORMAL" -> number = 1
                "FIGHTING" -> number = 2
                "FLYING" -> number = 3
                "POISON" -> number = 4
                "GROUND" -> number = 5
                "ROCK" -> number = 6
                "BUG" -> number = 7
                "GHOST" -> number = 8
                "STEEL" -> number = 9
                "FIRE" -> number = 10
                "WATER" -> number = 11
                "GRASS" -> number = 12
                "ELECTRIC" -> number = 13
                "PSYCHIC" -> number = 14
                "ICE" -> number = 15
                "DRAGON" -> number = 16
                "DARK" -> number = 17
                "FAIRY" -> number = 18
            }
            loading.value = true

            var result: List<Pokemon> = if (type != "ALL"){
                repository.fetchPokemonByType(number)
            } else {
                repository.fetchPokemonList(21)
            }

            pokemons.value = result
            loading.value = false
        }

    }

    fun onSelectedTypeChanged(type: String){
        val pokemonType = getPokemonType(type)
        selectedType.value = pokemonType
        pokemonByType(type)
    }

    fun onChangeTypeScrollPosition(position: Float){
        typeScrollPosition = position
    }

}