package com.example.shggv2.viewModel

import android.util.Log
import com.example.shggv2.remote.Riot.ApiProvider
import com.example.shggv2.remote.Ddragon.Ddragon
import com.example.shggv2.remote.Ddragon.DdragonApiProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateVersion() {

    private val TAG = "UpdateVersion"

    companion object {
        var version: String = "default"
    }

    fun dragonVersion() {
        val apiProvider = DdragonApiProvider.getInstance().create(Ddragon::class.java)

        val call: Call<List<String>> = apiProvider.getVersion()

        call.enqueue(object : Callback<List<String>> {
            override fun onResponse(
                    call: Call<List<String>>,
                    response: Response<List<String>>
            ) {
                Log.d(TAG, "onResponse: ")
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                Log.d(TAG, "onFailure: ")
            }

        })
    }
}