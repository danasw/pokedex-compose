package com.dana.pokedexcompose.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dana.pokedexcompose.presentation.ui.pokemon_list.PokemonType
import com.dana.pokedexcompose.presentation.ui.pokemon_list.getAllPokemonType
import kotlinx.coroutines.launch

@Composable
fun PokemonTypeBar(
    scrollPosition: Int,
    selectedType: PokemonType?,
    onSelectedTypeChanged: (String) -> Unit,
    onChangeTypeScrollPosition: (Float) -> Unit,
    onExecuteType: (String) -> Unit,
) {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    LazyRow(
        modifier = Modifier
            .padding(start = 8.dp, bottom = 8.dp)
    ) {
        scope.launch {
            scrollState.scrollTo(scrollPosition)
        }
        for (type in getAllPokemonType()) {
            item {
                PokemonTypeChip(
                    type = type.value,
                    isSelected = selectedType == type,
                    onSelectedTypeChanged = {
                        onSelectedTypeChanged(it)
                        onChangeTypeScrollPosition(scrollState.value.toFloat())
                    },
                    onExecuteType = {
                        onExecuteType(type.value)
                    }
                )
            }
        }
    }
}