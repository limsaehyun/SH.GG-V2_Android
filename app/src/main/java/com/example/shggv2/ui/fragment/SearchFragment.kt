package com.example.shggv2.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.shggv2.ApiProvider
import com.example.shggv2.RiotAPI
import com.example.shggv2.SummonerResponse
import com.example.shggv2.UserResponse
import com.example.shggv2.databinding.FragmentRankBinding
import com.example.shggv2.databinding.FragmentSearchBinding
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

        val call:Call<SummonerResponse> = apiProvider.getSummoner(userName, api_key)

        call.enqueue(object : Callback<SummonerResponse> {
            override fun onResponse(
                call: Call<SummonerResponse>,
                response: Response<SummonerResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d(TAG, "onResponse: " + response.body()?.id.toString())
                    getUserInfo(response.body()?.id.toString())
                } else {
                    Toast.makeText(context, "소환사가 존재하지 않습니다.", Toast.LENGTH_SHORT)
                }
            }

            override fun onFailure(call: Call<SummonerResponse>, t: Throwable) {
                Toast.makeText(context, "소환사가 존재하지 않습니다.", Toast.LENGTH_SHORT)
                Log.d(TAG, "onFailure: ")
            }

        })
    }
    
    private fun getUserInfo(id: String) {
        val apiProvider = ApiProvider.getInstance().create(RiotAPI::class.java)
        apiProvider.getUser(id, api_key).enqueue(object : Callback<List<UserResponse>> {
            override fun onResponse(
                call: Call<List<UserResponse>>,
                response: Response<List<UserResponse>>
            ) {
//                if(i in response.body().tier)
            }

            override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
                Log.d(TAG, "onFailure: 1")
            }
        })
    }
}