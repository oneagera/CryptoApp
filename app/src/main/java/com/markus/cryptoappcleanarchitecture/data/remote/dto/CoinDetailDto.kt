package com.markus.cryptoappcleanarchitecture.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.markus.cryptoappcleanarchitecture.domain.model.CoinDetail

data class CoinDetailDto(
    val description: String,
    val developmentStatus: String,
    val firstDataAt: String,
    val hardwareWallet: Boolean,
    val hashAlgorithm: String,
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    val isNew: Boolean,
    val lastDataAt: String,
    val links: Links,
    val linksExtended: List<LinksExtended>,
    val logo: String,
    val message: String,
    val name: String,
    val openSource: Boolean,
    val orgStructure: String,
    val proofType: String,
    val rank: Int,
    val startedAt: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val type: String,
    val whitePaper: Whitepaper
)

fun CoinDetailDto.toCoinDetail(): CoinDetail { //maps CoinDetailDto to CoinDetail.kt API to Ui
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name }, //list of tags so we remap it just to get the name of the tag as a string
        team = team
    )
}