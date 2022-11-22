package com.example.pokedexappwithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedexappwithjetpackcompose.app.pokemonList.PokemonListScreen
import com.example.pokedexappwithjetpackcompose.ui.theme.PokedexAppWithJetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexAppWithJetpackComposeTheme {
                Home()
            }
        }
    }
}

@Composable
fun Home() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "pokemon_list_screen"
    ) {
        composable("pokemon_list_screen") {
            PokemonListScreen(navController = navController)
        }
        composable("pokemon_details_screen/{dominantColor}/{pokemonName}",
            arguments = listOf(
                navArgument("dominantColor") {
                    type = NavType.IntType
                },
                navArgument("pokemonName") {
                    type = NavType.StringType
                }
            )
        ) {
            val dominantColor = remember {
                val color = it.arguments?.getInt("dominantColor")
                color?.let { Color(it) } ?: Color.White
            }
            val pokemon = remember {
                it.arguments?.getString("pokemonName")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexAppWithJetpackComposeTheme {
        Home()
    }
}