package com.example.pokedexappwithjetpackcompose.app.pokemonDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pokedexappwithjetpackcompose.data.remote.responses.Pokemon
import com.example.pokedexappwithjetpackcompose.util.Resource

/**
 * Created by Gideon Olarewaju on 23/11/2022.
 */

@Composable
fun pokemonDetailsScreen(
    dominantColor: String,
    pokemonName: String,
    navController: NavController,
    topPadding: Dp = 20.dp,
    pokemonImageSize: Dp = 200.dp,
    viewModel: PokemonDetailViewModel = hiltViewModel()
){
    val produceState = produceState<Resource<Pokemon>>(initialValue = Resource.Loading()){
        value = viewModel.getPokemonDetail(pokemonName)
    }.value
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 16.dp)
    ) {

    }

}