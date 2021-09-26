package com.example.shggv2.viewModel

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.shggv2.model.DTO.SummonerDTO
import com.example.shggv2.model.DTO.UserDTO
import com.example.shggv2.remote.ApiProvider
import com.example.shggv2.remote.RiotAPI
import com.example.shggv2.remote.api_key
import com.example.shggv2.ui.activity.UserActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Search(val context: Context) {

    companion object {
        var SoloTier = "UNRANK"
        var SoloRank = "I"
        var SoloName = ""
        var SoloWins = 0
        var SoloLosses = 0
        var SoloLeaguePoints = 0

        var FlexTier = "UNRANK"
        var FlexRank = "I"
        var FlexName = ""
        var FlexWins = 0
        var FlexLosses = 0
        var FlexLeaguePoints = 0

        lateinit var userName: String
        lateinit var profileIconId: String
    }

    fun getSummoner(_userName: String) {
        userName = _userName
        val apiProvider = ApiProvider.getInstance().create(RiotAPI::class.java)

        val call: Call<SummonerDTO> = apiProvider.getSummoner(_userName, api_key)

        call.enqueue(object : Callback<SummonerDTO> {
            override fun onResponse(
                call: Call<SummonerDTO>,
                response: Response<SummonerDTO>
            ) {
                if (response.isSuccessful) {
                    getUserInfo(response.body()?.id.toString())
                    profileIconId = response.body()?.profileIconId.toString()
                } else {
                    Toast.makeText(context, "소환사가 존재하지 않습니다.", Toast.LENGTH_SHORT)
                }
            }

            override fun onFailure(call: Call<SummonerDTO>, t: Throwable) {
                Toast.makeText(context, "소환사가 존재하지 않습니다.", Toast.LENGTH_SHORT)
            }

        })
    }

    private fun getUserInfo(id: String) {
        val riotAPI = ApiProvider.getInstance().create(RiotAPI::class.java)

        val call: Call<List<UserDTO>> = riotAPI.getUser(id, api_key)

        call.enqueue(object : Callback<List<UserDTO>> {
            override fun onResponse(call: Call<List<UserDTO>>, response: Response<List<UserDTO>>) {
                val data: List<UserDTO>? = response.body()
                data?.let { saveUserInfo(it) }
            }

            override fun onFailure(call: Call<List<UserDTO>>, t: Throwable) {
            }
        })
    }

    private fun saveUserInfo(userInfo: List<UserDTO>) {

        if(userInfo.size > 0) {
            SoloTier = userInfo.get(0).tier
            SoloRank = userInfo.get(0).rank
            SoloName = userInfo.get(0).summonerName
            SoloWins = userInfo.get(0).wins
            SoloLosses = userInfo.get(0).losses
            SoloLeaguePoints = userInfo.get(0).leaguePoints
        }
        if(userInfo.size > 1) {
            FlexTier = userInfo.get(1).tier
            FlexRank = userInfo.get(1).rank
            FlexName = userInfo.get(1).summonerName
            FlexWins = userInfo.get(1).wins
            FlexLosses = userInfo.get(1).losses
            FlexLeaguePoints = userInfo.get(0).leaguePoints
        }

        context.startActivity(Intent(context, UserActivity::class.java))
    }

}