package com.example.shggv2.remote

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.shggv2.R
import com.example.shggv2.model.DTO.SummonerDTO
import com.example.shggv2.model.RankRvData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RankAdapter(val context: Context, val studentList: ArrayList<RankRvData>):
        RecyclerView.Adapter<RankAdapter.Holder>() {

    private val TAG = "RankAdapter"

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val tvRankCount = itemView?.findViewById<TextView>(R.id.tvRankCount)
        val tvRankUserName = itemView?.findViewById<TextView>(R.id.tvRankUserName)
        val ivRanTierBg = itemView?.findViewById<RelativeLayout>(R.id.ivRanTierBg)
        val tvRankUserTier = itemView?.findViewById<TextView>(R.id.tvRankUserTier)
        val tvRankLP = itemView?.findViewById<TextView>(R.id.tvRankLP)

        fun bind(rankRvData: RankRvData, context: Context) {
            tvRankCount?.text = rankRvData.rank.toString()
            tvRankUserName?.text = rankRvData.summonerName
            tvRankLP?.text = rankRvData.leaguePoints.toString()

            when(rankRvData.tier) {
                "CHALLENGER" -> {
                    tvRankUserTier?.text = "C1"
                    ivRanTierBg?.setBackgroundColor(ContextCompat.getColor(context, R.color.tierChallengerBG))
                }
                "GRANDMASTER" -> {
                    tvRankUserTier?.text = "GM1"
                    ivRanTierBg?.setBackgroundColor(ContextCompat.getColor(context, R.color.tierGrandMasterBG))
                }
                "MASTER" -> {
                    tvRankUserTier?.text = "M1"
                    ivRanTierBg?.setBackgroundColor(ContextCompat.getColor(context, R.color.tierMasterBG))
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.rank_view, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(studentList[position], context)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}