package com.example.shggv2.remote.Ddragon

import retrofit2.Call
import retrofit2.http.GET

interface Ddragon {
    @GET("versions.json")
    fun getVersion(): Call<List<String>>
}