package com.example.pokedexappwithjetpackcompose.repository

import com.example.pokedexappwithjetpackcompose.data.remote.PokeApi
import com.example.pokedexappwithjetpackcompose.data.remote.responses.Pokemon
import com.example.pokedexappwithjetpackcompose.data.remote.responses.PokemonList
import com.example.pokedexappwithjetpackcompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

/**
 * Created by Gideon Olarewaju on 21/11/2022.
 */

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun fetchPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.fetchPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("Oops!! An error occured....")
        }
        return Resource.Success(response)
    }

    suspend fun fetchPokemonDetails(name: String): Resource<Pokemon> {
        val response = try {
            api.fetchPokemon(name)
        } catch (e: Exception) {
            return Resource.Error("Oops!! An error occured....")
        }
        return Resource.Success(response)
    }
}