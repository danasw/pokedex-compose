package com.dana.pokedexcompose.presentation.ui.pokemon_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dana.pokedexcompose.presentation.components.PokemonCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonListFragment : Fragment() {

    val viewModel: PokemonListViewModel by viewModels()

    @ExperimentalFoundationApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                val pokemons = viewModel.pokemons.value
                
                LazyVerticalGrid(
                    cells = GridCells.Adaptive(minSize = 128.dp),
                    ){
                    itemsIndexed(
                        items = pokemons
                    ){  index, pokemon ->
                        PokemonCard(pokemon = pokemon, onClick = {})
                    }
                }
                
//                LazyColumn{
//                    itemsIndexed(
//                        items = pokemons
//                    ){  index, pokemon ->
//                        PokemonCard(pokemon = pokemon, onClick = {})
//                    }
//                }
            }
        }
    }
}