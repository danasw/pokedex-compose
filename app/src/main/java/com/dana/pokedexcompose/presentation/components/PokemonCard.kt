package com.dana.pokedexcompose.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dana.pokedexcompose.R
import com.dana.pokedexcompose.domain.model.Pokemon
import com.dana.pokedexcompose.util.DEFAULT_POKEMON_IMAGE
import com.dana.pokedexcompose.util.loadPicture
import java.util.*

@Composable
fun PokemonCard(
    pokemon: Pokemon,
    onClick: () -> Unit,
){
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(top = 6.dp, bottom = 6.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            val image = loadPicture(
                url = pokemon.getImgUrl(),
                defaultImage = DEFAULT_POKEMON_IMAGE).value
            if (image != null) {
                Image(
                    bitmap = image.asImageBitmap(),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Fit
                )
            }
            Text(
                text = pokemon.name.uppercase(Locale.getDefault()),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}