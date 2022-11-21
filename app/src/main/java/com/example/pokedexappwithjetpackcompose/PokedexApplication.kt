package com.example.pokedexappwithjetpackcompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by Gideon Olarewaju on 21/11/2022.
 */

@HiltAndroidApp
class PokedexApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}