package com.example.shggv2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.shggv2.databinding.ActivityUserBinding
import com.example.shggv2.ui.fragment.SearchFragment
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URI
import java.net.URL

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var SoloWins = SearchFragment.SoloWins
        var SoloLosses = SearchFragment.SoloLosses
        var FlexWins = SearchFragment.FlexWins
        var FlexLosses = SearchFragment.FlexLosses

        binding.tvUserName.setText(SearchFragment.userName)

        binding.tvSoloTier.setText(SearchFragment.SoloRank + " " + SearchFragment.SoloTier)
        binding.tvSoloLP.setText(SearchFragment.SoloLeaguePoints.toString() + "LP / " + SoloWins + "승 " + SoloLosses + "패")
        binding.tvSoloWinRate.setText("승률 : " + SoloWins / SoloLosses * 100 + " %")

        binding.tvSoloTier.setText(SearchFragment.FlexRank + " " + SearchFragment.FlexTier)
        binding.tvSoloLP.setText(SearchFragment.FlexLeaguePoints.toString() + "LP / " + FlexWins + "승 " + FlexLosses + "패")
        binding.tvSoloWinRate.setText("승률 : " + FlexWins / FlexLosses * 100 + " %")

        var image_task: URLtoBitmapTask = URLtoBitmapTask()
        image_task = URLtoBitmapTask().apply {
            url = URL("http://ddragon.leagueoflegends.com/cdn/10.6.1/img/profileicon/" + SearchFragment.profileIconId + ".png")
        }
        var bitmap: Bitmap = image_task.execute().get()
        binding.ivProfileImage.setImageBitmap(bitmap)
    }
}