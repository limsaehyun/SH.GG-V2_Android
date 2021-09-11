package com.example.shggv2.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shggv2.R
import com.example.shggv2.databinding.FragmentRankBinding
import com.example.shggv2.databinding.RankViewBinding
import com.example.shggv2.model.RankDTO
import com.example.shggv2.model.RankData
import com.example.shggv2.model.UserDTO
import com.example.shggv2.remote.ApiProvider
import com.example.shggv2.remote.RankAdapter
import com.example.shggv2.remote.RiotAPI
import com.example.shggv2.remote.api_key
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RankFragment : Fragment() {

    private val TAG = "RankFragment"
    
    private lateinit var binding: FragmentRankBinding

    private lateinit var rvRank: RecyclerView

    private var rankList = arrayListOf<RankDTO>()


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRankBinding.inflate(inflater, container, false)


        binding.rvRank.adapter = context?.let { RankAdapter(it, rankList) }
        binding.rvRank.layoutManager = LinearLayoutManager(context)

        binding.rvRank.setHasFixedSize(true)


        binding.tvSoloRank.setOnClickListener {
            getRank("RANKED_SOLO_5x5", "CHALLENGER", "I")
        }

        return binding.root
    }

    private fun getRank(queue: String, tier: String, division: String) {
        val apiProvider = ApiProvider.getInstance().create(RiotAPI::class.java)

        val call: Call<List<RankDTO>> = apiProvider.getRank(api_key, queue, tier, division)

        call.enqueue(object : Callback<List<RankDTO>> {
            override fun onResponse(call: Call<List<RankDTO>>, response: Response<List<RankDTO>>) {
                Log.d(TAG, "onResponse: ")
            }

            override fun onFailure(call: Call<List<RankDTO>>, t: Throwable) {
                Log.d(TAG, "onFailure: ")
            }
        })
    }

    override fun onResume() {
        super.onResume()
        
    }
}
