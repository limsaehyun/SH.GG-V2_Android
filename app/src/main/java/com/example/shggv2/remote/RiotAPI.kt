package com.example.shggv2.remote

import com.example.shggv2.model.RankDTO
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

    @GET("https://kr.api.riotgames.com/lol/league-exp/v4/entries")
    fun getRank(
        @Query("api_key") apiKey: String,
        @Query("queue") queue: String,
        @Query("tier") tier: String,
        @Query("division") division: String
    ): Call<List<RankDTO>>
}