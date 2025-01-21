package com.example.watchmodeapp.model

import kotlinx.serialization.Serializable

@Serializable
data class TitleSummary(
    val id: Int,
    val title: String,
    val type: String,
    val year: Int
)