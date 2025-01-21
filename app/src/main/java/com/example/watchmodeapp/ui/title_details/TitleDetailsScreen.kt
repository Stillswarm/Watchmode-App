package com.example.watchmodeapp.ui.title_details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.watchmodeapp.AppViewModel
import com.example.watchmodeapp.ui.common.ErrorScreen
import com.example.watchmodeapp.ui.common.LoadingScreen
import com.example.watchmodeapp.util.RequestStatus
import org.koin.androidx.compose.koinViewModel

@Composable
fun TitleDetailsScreen(
    id: Int,
    modifier: Modifier = Modifier,
    viewModel: AppViewModel = koinViewModel()
) {
    val itemRequest = viewModel.itemRequest
    LaunchedEffect(Unit) {
        viewModel.getTitleById(id)
    }
    when (itemRequest) {
        is RequestStatus.Error -> {
            ErrorScreen(itemRequest.msg, modifier)
        }

        RequestStatus.Idle -> {}
        RequestStatus.Loading -> {
            LoadingScreen(modifier)
        }

        is RequestStatus.Success -> {
            val title = itemRequest.data
            TitleDetailsContent(title = title, modifier = modifier)
        }
    }
}