package com.example.shggv2.remote

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shggv2.R
import com.example.shggv2.model.RankDTO
import com.example.shggv2.model.RankData
import com.example.shggv2.model.UserDTO


class RankAdapter(val context: Context, val studentList: ArrayList<RankDTO>):
        RecyclerView.Adapter<RankAdapter.Holder>() {

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val tvRankCount = itemView?.findViewById<TextView>(R.id.tvRankCount)
        val ivRankUserImage = itemView?.findViewById<ImageView>(R.id.ivRankUserImage)
        val tvRankUserName = itemView?.findViewById<TextView>(R.id.tvRankUserName)
        val ivRanTierBg = itemView?.findViewById<ImageView>(R.id.ivRanTierBg)
        val tvRankUserTier = itemView?.findViewById<TextView>(R.id.tvRankUserTier)
        val tvRankLP = itemView?.findViewById<TextView>(R.id.tvRankLP)

        fun bind(rankDTO: RankDTO, context: Context) {
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