package com.example.shggv2.remote.Ddragon

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DdragonApiProvider {
    private var instance: Retrofit?=null
    private var BASE_URL = "https://ddragon.leagueoflegends.com/api/"

    fun getInstance(): Retrofit {
        if(instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return instance!!
    }
}