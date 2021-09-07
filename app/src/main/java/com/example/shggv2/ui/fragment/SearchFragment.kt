package com.example.shggv2.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.shggv2.ApiProvider
import com.example.shggv2.RiotAPI
import com.example.shggv2.SummonerResponse
import com.example.shggv2.databinding.FragmentRankBinding
import com.example.shggv2.databinding.FragmentSearchBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

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
        apiProvider.getSummoner(userName).enqueue(object : Callback<SummonerResponse> {
            override fun onResponse(call: Call<SummonerResponse>, response: Response<SummonerResponse>) {
                if(response.isSuccessful) {
                    setSummoner(response.body()!!)
                } else {
                    Toast.makeText(context, "소환사가 존재하지 않습니다.", Toast.LENGTH_SHORT)
                }
            }

            override fun onFailure(call: Call<SummonerResponse>, t: Throwable) {
                Toast.makeText(context, "소환사가 존재하지 않습니다.", Toast.LENGTH_SHORT)
            }

        })
    }

    private fun setSummoner(summonerResponse: SummonerResponse) {

    }


}