package com.example.pokedexappwithjetpackcompose.app.pokemonDetails

import androidx.lifecycle.ViewModel
import com.example.pokedexappwithjetpackcompose.data.remote.responses.Pokemon
import com.example.pokedexappwithjetpackcompose.repository.PokemonRepository
import com.example.pokedexappwithjetpackcompose.util.Resource
import javax.inject.Inject

/**
 * Created by Gideon Olarewaju on 23/11/2022.
 */
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    suspend fun getPokemonDetail(pokemonName: String): Resource<Pokemon> {
        return repository.fetchPokemonDetails(pokemonName)
    }

}