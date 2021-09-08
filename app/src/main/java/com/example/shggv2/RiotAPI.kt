package com.example.shggv2

import com.example.shggv2.model.SummonerDTO
import com.example.shggv2.model.UserDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RiotAPI {
    @GET("lol/summoner/v4/summoners/by-name/{summonerName}")
    fun getSummoner(
        @Path("summonerName") name: String,
        @Query("api_key") apiKey: String
    ): Call<SummonerDTO>

    @GET("lol/league/v4/entries/by-summoner/{encryptedSummonerId}")
    fun getUser(
        @Path("encryptedSummonerId") id: String,
        @Query("api_key") apiKey: String
    ): Call<List<UserDTO>>
}