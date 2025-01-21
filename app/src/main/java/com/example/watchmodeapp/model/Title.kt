package com.example.watchmodeapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Title(
    val backdrop: String? = null,
    @SerialName("genre_names")
    val genreNames: List<String>? = null,
    val genres: List<Int>? = null,
    val id: Int,
    @SerialName("original_language")
    val originalLanguage: String = "en",
    @SerialName("original_title")
    val originalTitle: String? = null,
    @SerialName("plot_overview")
    val plotOverview: String? = null,
    val poster: String? = null,
    @SerialName("release_date")
    val releaseDate: String? = null,
    @SerialName("runtime_minutes")
    val runtimeMinutes: Int? = null,
    @SerialName("similar_titles")
    val similarTitles: List<Int>? = null,
    val title: String,
    val type: String? = null,
    @SerialName("user_rating")
    val userRating: Double? = null,
    val year: Int? = null
)