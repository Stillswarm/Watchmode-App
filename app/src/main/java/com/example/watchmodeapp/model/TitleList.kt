package com.example.watchmodeapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TitleList(
    val page: Int,
    @SerialName("titles")
    val titleSummaries: List<TitleSummary>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
)