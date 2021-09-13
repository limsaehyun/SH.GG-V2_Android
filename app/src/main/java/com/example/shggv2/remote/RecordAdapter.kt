package com.example.shggv2.remote

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shggv2.R
import com.example.shggv2.model.DTO.RecordRvData
import com.example.shggv2.model.RankRvData

class RecordAdapter (val context: Context, val recordList: ArrayList<RecordRvData>):
        RecyclerView.Adapter<RecordAdapter.Holder>() {

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val tvRankCount = itemView?.findViewById<TextView>(R.id.tvRankCount)

        fun bind(record: RankRvData, context: Context) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordAdapter.Holder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecordAdapter.Holder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
