package com.example.shggv2.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.shggv2.remote.ApiProvider
import com.example.shggv2.remote.RiotAPI
import com.example.shggv2.ui.activity.UserActivity
import com.example.shggv2.databinding.FragmentSearchBinding
import com.example.shggv2.model.DTO.SummonerDTO
import com.example.shggv2.model.DTO.UserDTO
import com.example.shggv2.remote.Search
import com.example.shggv2.remote.api_key
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

    private val TAG = "SearchFragment"

    private lateinit var userName: String;

    private lateinit var binding: FragmentSearchBinding

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
                val search = context?.let { it1 -> Search(it1) }
                search?.getSummoner(userName)
            }
        }

        return binding.root
    }
}