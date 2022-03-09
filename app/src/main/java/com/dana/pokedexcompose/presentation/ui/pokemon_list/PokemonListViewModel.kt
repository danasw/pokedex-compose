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

    init {
        newFetchPokemonList()
    }

    fun newFetchPokemonList(){
        viewModelScope.launch {
            val result= repository.fetchPokemonList()
            pokemons.value = result
        }
    }

}