package com.example.watchmodeapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watchmodeapp.model.Title
import com.example.watchmodeapp.network.WatchmodeApiService
import com.example.watchmodeapp.util.RequestStatus
import com.example.watchmodeapp.util.SortingOrder
import kotlinx.coroutines.launch
import kotlin.collections.List

class AppViewModel(
    private val apiService: WatchmodeApiService
) : ViewModel() {
    var requestStatus: RequestStatus<List<Title>> by mutableStateOf(RequestStatus.Loading)
        private set

    var itemRequest: RequestStatus<Title> by mutableStateOf(RequestStatus.Idle)
        private set

    var pageNo by mutableIntStateOf(1)
    var tvSelected by mutableStateOf(false)
    var moviesSelected by mutableStateOf(true)

    fun getAllPosts(pageNo: Int, typeList: List<String>, limit: Int = 18, initial: Boolean = false) {
        if (initial && requestStatus is RequestStatus.Success) return
        viewModelScope.launch {
            val types = typeList.joinToString(",")
            requestStatus = RequestStatus.Loading
            try {
                val response = apiService.getTitleList(
                    page = pageNo,
                    sortBy = SortingOrder.popularity_desc.toString(),
                    types = types,
                    limit = limit
                )
                if (response.isSuccessful) {
                    val titles = response.body()!!.titleSummaries.map {
                        val x = apiService.getTitleById(it.id)
                        x.body() ?: throw Exception(x.message())
                    }
                    requestStatus = RequestStatus.Success(titles)
                } else {
                    requestStatus = RequestStatus.Error(response.message())
                }
            } catch (e: Exception) {
                requestStatus = RequestStatus.Error(e.message ?: "Unknown API Error")
            }
        }
    }

    fun getTitleById(id: Int) {
        itemRequest = RequestStatus.Loading
        if (requestStatus is RequestStatus.Success) {

            val titles = (requestStatus as RequestStatus.Success).data
            val title = titles.find { it.id == id }
            itemRequest = if (title == null) RequestStatus.Error("No Such Item")
            else RequestStatus.Success(title)

        } else {
            itemRequest = RequestStatus.Error("Item Details Unavailable!")
        }
    }

    fun nextPage() {
        ++pageNo
        getAllPosts(pageNo, getTypesList())
    }

    fun previousPage() {
        if (pageNo > 1) {
            --pageNo
            getAllPosts(pageNo, getTypesList())
        }
    }

    fun setMovies() {
        moviesSelected = true
        tvSelected = false
        getAllPosts(pageNo, getTypesList())
    }

    fun setTv() {
        moviesSelected = false
        tvSelected = true
        getAllPosts(pageNo, getTypesList())
    }

    private fun getMovieTypes() = listOf("movie", "short_film")
    private fun getTvTypes() = listOf("tv_series", "tv_special", "tv_miniseries")

    fun getTypesList() = if (tvSelected) getTvTypes() else getMovieTypes()
}