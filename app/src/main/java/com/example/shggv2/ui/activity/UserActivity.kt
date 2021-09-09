package com.example.shggv2.ui.activity

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.shggv2.R
import com.example.shggv2.databinding.ActivityUserBinding
import com.example.shggv2.task.URLtoBitmapTask
import com.example.shggv2.ui.fragment.SearchFragment
import java.net.URL

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    private val TAG = "UserActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var SoloWins = SearchFragment.SoloWins
        var SoloLosses = SearchFragment.SoloLosses
        var FlexWins = SearchFragment.FlexWins
        var FlexLosses = SearchFragment.FlexLosses

        binding.tvUserName.setText(SearchFragment.userName)

        binding.tvSoloTier.setText(SearchFragment.SoloTier + " " + SearchFragment.SoloRank)
        binding.tvSoloLP.setText(SearchFragment.SoloLeaguePoints.toString() + "LP / " + SoloWins + "승 " + SoloLosses + "패")
        binding.tvSoloWinRate.setText("승률 : " + SoloWins / SoloLosses * 100 + " %")

        binding.tvFlexTier.setText(SearchFragment.FlexTier + " " + SearchFragment.FlexRank)
        binding.tvFlexLP.setText(SearchFragment.FlexLeaguePoints.toString() + "LP / " + FlexWins + "승 " + FlexLosses + "패")
        binding.tvFlexWinRate.setText("승률 : " + FlexWins / FlexLosses * 100 + " %")

        var image_task: URLtoBitmapTask = URLtoBitmapTask()
        image_task = URLtoBitmapTask().apply {
            url = URL("http://ddragon.leagueoflegends.com/cdn/10.6.1/img/profileicon/" + SearchFragment.profileIconId + ".png")
        }
        var bitmap: Bitmap = image_task.execute().get()
        binding.ivProfileImage.setImageBitmap(bitmap)

        Log.d(TAG, "onCreate: " + SearchFragment.SoloRank)

        when(SearchFragment.SoloTier) {
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
        when(SearchFragment.FlexTier) {
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