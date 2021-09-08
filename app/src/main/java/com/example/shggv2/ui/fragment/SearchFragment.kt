package com.example.shggv2.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.shggv2.ApiProvider
import com.example.shggv2.RiotAPI
import com.example.shggv2.UserActivity
import com.example.shggv2.databinding.FragmentSearchBinding
import com.example.shggv2.model.SummonerDTO
import com.example.shggv2.model.UserDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

    private val TAG = "SearchFragment"
    private lateinit var binding: FragmentSearchBinding

    companion object {
        var SoloTier = "UNRANK"
        var SoloRank = "I"
        var SoloName = ""
        var SoloWins = "0"
        var SoloLosses = "0"

        var FlexTier = "UNRANK"
        var FlexRank = "I"
        var FlexName = ""
        var FlexWins = "0"
        var FlexLosses = "0"

        lateinit var userName: String
        lateinit var profileIconId: String

        var api_key = "RGAPI-de257029-841b-42da-b6f9-cccfa87c3bea"
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchBinding.inflate(inflater, container, false)

        binding.ibSearch.setOnClickListener {
            userName = binding.etUserName.text.toString()
            if(userName.isEmpty()) {
                Toast.makeText(context, "소환사 닉네임을 입력해주세요!", Toast.LENGTH_SHORT).show()
            } else {
                getSummoner(userName)
            }
        }

        return binding.root
    }

    private fun getSummoner(userName: String) {
        val apiProvider = ApiProvider.getInstance().create(RiotAPI::class.java)

        val call:Call<SummonerDTO> = apiProvider.getSummoner(userName, api_key)

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
        }
        if(userInfo.size > 1) {
            FlexTier = userInfo.get(1).tier
            FlexRank = userInfo.get(1).rank
            FlexName = userInfo.get(1).summonerName
            FlexWins = userInfo.get(1).wins
            FlexLosses = userInfo.get(1).losses
        }

        startActivity(Intent(context, UserActivity::class.java))
    }
}