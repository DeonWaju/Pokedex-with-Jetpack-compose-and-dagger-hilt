package com.example.pokedexappwithjetpackcompose.data.remote

import com.example.pokedexappwithjetpackcompose.data.remote.responses.Pokemon
import com.example.pokedexappwithjetpackcompose.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Gideon Olarewaju on 21/11/2022.
 */
interface PokeApi {

    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun fetchPokemon(
        @Path("name") name: String,
    ): Pokemon
}