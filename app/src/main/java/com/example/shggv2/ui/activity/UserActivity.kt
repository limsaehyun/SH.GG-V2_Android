package com.example.shggv2.ui.activity

import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shggv2.R
import com.example.shggv2.databinding.ActivityUserBinding
<<<<<<< HEAD
import com.example.shggv2.model.StatisticsTier.SoloStatisticsTier
=======
import com.example.shggv2.viewModel.Search
>>>>>>> main
import com.example.shggv2.task.URLtoBitmapTask
import java.net.URL

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    private val TAG = "UserActivity"

    private lateinit var soloStatisticsTier: SoloStatisticsTier

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var SoloWins = Search.SoloWins
        var SoloLosses = Search.SoloLosses
        var FlexWins = Search.FlexWins
        var FlexLosses = Search.FlexLosses

<<<<<<< HEAD
//        Log.d(TAG, "테스트 출력 onCreate: " + soloStatisticsTier.test)
//        Log.d(TAG, "테스트 출력 onCreate: " + soloStatisticsTier.soloMap["테스트1"])

//        val percent = when(SearchFragment.SoloTier) {
//            "BRONZE" -> soloStatisticsTier.map[1]
//            else -> 0
//        }

        binding.tvUserName.setText(SearchFragment.userName)
=======
        binding.tvUserName.setText(Search.userName)
>>>>>>> main

        if(Search.SoloTier != "UNRANK") {
            binding.tvSoloTier.setText(Search.SoloTier + " " + Search.SoloRank)
            binding.tvSoloLP.setText(Search.SoloLeaguePoints.toString() + "LP / " + SoloWins + "승 " + SoloLosses + "패")
            binding.tvSoloWinRate.setText("승률 : " + SoloWins / SoloLosses * 100 + " %")
        }

        if(Search.FlexTier != "UNRANK") {
            binding.tvFlexTier.setText(Search.FlexTier + " " + Search.FlexRank)
            binding.tvFlexLP.setText(Search.FlexLeaguePoints.toString() + "LP / " + FlexWins + "승 " + FlexLosses + "패")
            binding.tvFlexWinRate.setText("승률 : " + FlexWins / FlexLosses * 100 + " %")
        }

        var image_task: URLtoBitmapTask = URLtoBitmapTask()
        image_task = URLtoBitmapTask().apply {
            url = URL("http://ddragon.leagueoflegends.com/cdn/10.6.1/img/profileicon/" + Search.profileIconId + ".png")
        }
        var bitmap: Bitmap = image_task.execute().get()
        binding.ivProfileImage.setImageBitmap(bitmap)

        when(Search.SoloTier) {
            "UNRANK" -> binding.ivSoloTier.setImageResource(R.drawable.ic_rank_unrank)
            "IRON" -> binding.ivSoloTier.setImageResource(R.drawable.ic_rank_iron)
            "BRONZE" -> binding.ivSoloTier.setImageResource(R.drawable.ic_rank_bronze)
            "SILVER" -> binding.ivSoloTier.setImageResource(R.drawable.ic_rank_silver)
            "GOLD" -> binding.ivSoloTier.setImageResource(R.drawable.ic_rank_gold)
            "PLATINUM" -> binding.ivSoloTier.setImageResource(R.drawable.ic_rank_platinum)
            "DIAMOND" -> binding.ivSoloTier.setImageResource(R.drawable.ic_rank_diamond)
            "GRANDMASTER" -> binding.ivSoloTier.setImageResource(R.drawable.ic_rank_grandmaster)
            "CHALLENGER" -> binding.ivSoloTier.setImageResource(R.drawable.ic_rank_challenger)
        }
        when(Search.FlexTier) {
            "UNRANK" -> binding.ivFlexTier.setImageResource(R.drawable.ic_rank_unrank)
            "IRON" -> binding.ivFlexTier.setImageResource(R.drawable.ic_rank_iron)
            "BRONZE" -> binding.ivFlexTier.setImageResource(R.drawable.ic_rank_bronze)
            "SILVER" -> binding.ivFlexTier.setImageResource(R.drawable.ic_rank_silver)
            "GOLD" -> binding.ivFlexTier.setImageResource(R.drawable.ic_rank_gold)
            "PLATINUM" -> binding.ivFlexTier.setImageResource(R.drawable.ic_rank_platinum)
            "DIAMOND" -> binding.ivFlexTier.setImageResource(R.drawable.ic_rank_diamond)
            "GRANDMASTER" -> binding.ivFlexTier.setImageResource(R.drawable.ic_rank_grandmaster)
            "CHALLENGER" -> binding.ivFlexTier.setImageResource(R.drawable.ic_rank_challenger)
        }
    }
}