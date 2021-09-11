package com.example.shggv2.model.DTO

data class RankDTO(val leagueId: String, val queueType: String, val tier: String, val rank: String,
                    val summonerId: String, val summonerName: String, val leaguePoints: Int,
                    val wins: Int, val losses: Int, val veteran: Boolean, val inactive: Boolean,
                    val freshBlood: Boolean, val hotStreak: Boolean)
